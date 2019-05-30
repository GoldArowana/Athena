package com.aries.department.athena.dal;

import com.alibaba.fastjson.JSON;
import com.aries.department.athena.dal.repository.DailyRepository;
import org.junit.Test;

import java.util.List;

public class DailySignRepositoryTest {
    @Test
    public void addSignTest() {
        boolean effective = DailyRepository.addSignNow("athena_aries", 1L);
        System.out.println(effective);
    }

    @Test
    public void getMonthTest() {
        List<Long> monthSignList = DailyRepository.getMonthSignList("athena_aries", 1L, 2019, 5);
        System.out.println(JSON.toJSONString(monthSignList));
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void hasSignedTest() {
        boolean flag = DailyRepository.hasSigned("athena_aries", 1L, 2019, 5, 30);
        System.out.println(flag);
        System.out.println(System.currentTimeMillis());
    }
}
