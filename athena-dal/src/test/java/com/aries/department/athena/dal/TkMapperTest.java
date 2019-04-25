package com.aries.department.athena.dal;

import com.aries.department.athena.dal.mapper.StuMapper;
import com.aries.department.athena.dal.po.Stu;
import com.aries.department.athena.dal.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tk.mybatis.mapper.entity.Example;

public class TkMapperTest {
    @Test
    public void simpleTest() {
        try (SqlSession session = SqlSessionUtil.openSession("test")) {
            // 获取Mapper
            StuMapper stuMapper = session.getMapper(StuMapper.class);

            // 构建example
            Example example = new Example(Stu.class);
            example.setForUpdate(true);
            example.createCriteria().andBetween("id", 1, 3);

            // 输出结果
            System.out.println(stuMapper.selectByExample(example));
        }
    }
}
