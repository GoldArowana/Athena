package com.aries.department.athena.client.thrift;

import com.aries.department.athena.client.thrift.facade.DailySignFacade;
import org.junit.Test;

import java.util.List;

public class DailySignFacadeTest {
    @Test
    public void getSignListMonthOfTest() {
        List<Long> signListMonthOf = DailySignFacade.getSignListMonthOf(1L, System.currentTimeMillis());
        System.out.println(signListMonthOf);
    }

    @Test
    public void hashSignedTodayTest() {
        boolean hashSignedToday = DailySignFacade.hashSignedToday(1L);
        System.out.println(hashSignedToday);
    }

    @Test
    public void signNowIfNotSignedTodayTest() {
        boolean hashSignedToday = DailySignFacade.signNowIfNotSignedToday(2L);
        System.out.println(hashSignedToday);
    }
}
