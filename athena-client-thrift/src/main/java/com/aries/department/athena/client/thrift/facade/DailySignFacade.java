package com.aries.department.athena.client.thrift.facade;

import com.aries.department.athena.client.thrift.exception.CallFailedException;
import com.aries.department.athena.contract.thrift.dto.CompanyInfo;
import com.aries.department.athena.contract.thrift.service.DailySignService;
import com.aries.hera.client.thrift.ThriftHelper;
import com.aries.hera.core.utils.PropertiesProxy;
import org.apache.thrift.transport.TTransportException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.chrono.ChronoZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DailySignFacade {
    private static final CompanyInfo companyInfo;

    static {
        PropertiesProxy propertiesProxy = new PropertiesProxy("athena-pass.properties");
        String company = propertiesProxy.readProperty("company");
        String password = propertiesProxy.readProperty("password");
        companyInfo = new CompanyInfo(company, password, "");
    }

    public static String ping() {
        try {
            return ThriftHelper.call("Athena", DailySignService.Client.class, DailySignService.Client::ping);
        } catch (TTransportException e) {
            throw new CallFailedException("调用服务失败", e);
        }
    }

    public static boolean addSignNow(long staffId) {
        try {
            return ThriftHelper.call("Athena", DailySignService.Client.class, client -> client.addSignNow(companyInfo, staffId));
        } catch (TTransportException e) {
            throw new CallFailedException("调用服务失败", e);
        }
    }

    public static boolean hasSigned(long staffId, long startTimeMills, long endTimeMills) {
        try {
            return ThriftHelper.call("Athena", DailySignService.Client.class, client -> client.hasSigned(companyInfo, staffId, startTimeMills, endTimeMills));
        } catch (TTransportException e) {
            throw new CallFailedException("调用服务失败", e);
        }
    }

    public static boolean hashSignedToday(long staffId) {
        try {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

            LocalDateTime firstTimeOfDay = LocalDateTime.of(year, month, dayOfMonth, 0, 0);
            LocalDateTime lastTimeOfDay = firstTimeOfDay.plusDays(1).minusNanos(1);
            return ThriftHelper.call("Athena", DailySignService.Client.class, client -> client.hasSigned(companyInfo, staffId, localDateTimeToDate(firstTimeOfDay).getTime(), localDateTimeToDate(lastTimeOfDay).getTime()));
        } catch (TTransportException e) {
            throw new CallFailedException("调用服务失败", e);
        }
    }

    public static List<Long> getSignList(long staffId, long startTimeMills, long endTimeMills) {
        try {
            return ThriftHelper.call("Athena", DailySignService.Client.class, client -> client.getSignList(companyInfo, staffId, startTimeMills, endTimeMills));
        } catch (TTransportException e) {
            throw new CallFailedException("调用服务失败", e);
        }
    }

    public static List<Long> getSignListMonthOf(long staffId, long monthOfMills) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(monthOfMills);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;

            LocalDateTime firstTimeOfMonth = LocalDateTime.of(year, month, 1, 0, 0);
            LocalDateTime lastTimeDayOfMonth = firstTimeOfMonth.plusMonths(1).minusNanos(1);
            return ThriftHelper.call("Athena", DailySignService.Client.class, client -> client.getSignList(companyInfo, staffId, localDateTimeToDate(firstTimeOfMonth).getTime(), localDateTimeToDate(lastTimeDayOfMonth).getTime()));
        } catch (TTransportException e) {
            throw new CallFailedException("调用服务失败", e);
        }
    }

    public static boolean signNowIfNotSignedToday(long staffId) {
        try {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

            LocalDateTime firstTimeOfDay = LocalDateTime.of(year, month, dayOfMonth, 0, 0);
            LocalDateTime lastTimeOfDay = firstTimeOfDay.plusDays(1).minusNanos(1);
            return ThriftHelper.call("Athena", DailySignService.Client.class, client -> client.signNowIfNotSignedInPeriod(companyInfo, staffId, localDateTimeToDate(firstTimeOfDay).getTime(), localDateTimeToDate(lastTimeOfDay).getTime()));
        } catch (TTransportException e) {
            throw new CallFailedException("调用服务失败", e);
        }
    }

    public static boolean signNowIfNotSignedInPeriod(long staffId, long startTimeMills, long endTimeMills) {
        try {
            return ThriftHelper.call("Athena", DailySignService.Client.class, client -> client.signNowIfNotSignedInPeriod(companyInfo, staffId, startTimeMills, endTimeMills));
        } catch (TTransportException e) {
            throw new CallFailedException("调用服务失败", e);
        }
    }

    private static Date localDateTimeToDate(LocalDateTime localDate) {
        ZoneId zoneId = ZoneId.systemDefault();
        ChronoZonedDateTime<LocalDate> zonedDateTime = localDate.atZone(zoneId);
        return Date.from(zonedDateTime.toInstant());
    }
}
