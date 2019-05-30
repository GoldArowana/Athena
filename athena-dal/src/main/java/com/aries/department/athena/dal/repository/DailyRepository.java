package com.aries.department.athena.dal.repository;

import com.aries.department.athena.dal.mapper.DailyMapper;
import com.aries.department.athena.dal.po.DailySign;
import com.aries.department.athena.dal.util.SqlSessionUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.session.SqlSession;
import tk.mybatis.mapper.entity.Example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.chrono.ChronoZonedDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DailyRepository {
    public static boolean addSignNow(String database, long staffId) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            // 获取Mapper
            DailyMapper staffMapper = session.getMapper(DailyMapper.class);
            DailySign dailySign = new DailySign();
            dailySign.setStaffId(staffId);

            int effective = staffMapper.insertSelective(dailySign);
            return effective > 0;
        }
    }

    public static boolean hasSigned(String database, long staffId, Date start, Date end) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            // 获取Mapper
            DailyMapper staffMapper = session.getMapper(DailyMapper.class);
            Example example = new Example(DailySign.class);
            example.createCriteria()
                    .andEqualTo("staffId", staffId)
                    .andBetween("insertTime", start, end);

            System.out.println("---");
            System.out.println(start);
            System.out.println(end);

            int effective = staffMapper.selectCountByExample(example);
            return effective > 0;
        }
    }

    public static boolean hasSigned(String database, long staffId, int year, int month, int day) {
        LocalDateTime date = LocalDateTime.of(year, month, day, 0, 0);
        return hasSigned(database, staffId, localDateTimeToDate(date), localDateTimeToDate(date.plusDays(1).minusSeconds(1)));
    }

    public static List<Long> getSignList(String database, long staffId, Date start, Date end) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            // 获取Mapper
            DailyMapper staffMapper = session.getMapper(DailyMapper.class);
            Example example = new Example(DailySign.class);
            example.createCriteria()
                    .andEqualTo("staffId", staffId)
                    .andBetween("insertTime", start, end);

            List<DailySign> dailySignList = staffMapper.selectByExample(example);
            if (CollectionUtils.isEmpty(dailySignList)) {
                return Collections.emptyList();
            }
            return dailySignList.stream().map(dailySign -> dailySign.getInsertTime().getTime()).collect(Collectors.toList());
        }
    }

    public static List<Long> getSignList(String database, long staffId, long startMills, long endMills) {
        return getSignList(database, staffId, new Date(startMills), new Date(endMills));
    }

    public static List<Long> getMonthSignList(String database, long staffId, int year, int month) {
        LocalDate date = LocalDate.of(year, month, 1);
        return getSignList(database, staffId, localDateToDate(date), localDateToDate(date.plusMonths(1)));
    }

    private static Date localDateToDate(LocalDate localDate) {
        ZoneId zoneId = ZoneId.systemDefault();
        ChronoZonedDateTime<LocalDate> zonedDateTime = localDate.atStartOfDay(zoneId);
        return Date.from(zonedDateTime.toInstant());
    }

    private static Date localDateTimeToDate(LocalDateTime localDate) {
        ZoneId zoneId = ZoneId.systemDefault();
        ChronoZonedDateTime<LocalDate> zonedDateTime = localDate.atZone(zoneId);
        return Date.from(zonedDateTime.toInstant());
    }
}
