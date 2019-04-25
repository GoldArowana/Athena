package com.aries.department.athena.dal;

import com.aries.department.athena.dal.config.ConfigurationUtil;
import com.aries.department.athena.dal.config.SqlSessionFactoryUtil;
import com.aries.department.athena.dal.mapper.StuMapper;
import com.aries.department.athena.dal.po.Stu;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.session.Configuration;

import java.io.IOException;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) throws IOException {

        Configuration tkConfiguration = ConfigurationUtil.getTkConfigurationByDBName("test");

        // 根据tkConfiguration来获取SqlSessionFactory
        SqlSessionFactory sessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory(tkConfiguration);

        try (SqlSession session = sessionFactory.openSession()) {
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
