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
        // 从SqlMapConfig.xml里读取配置。如果mybatis的xml名不是这个，那么需要修改SqlSessionFactoryUtil里的常量。
        SqlSessionFactory factoryFromXml = SqlSessionFactoryUtil.getSqlSessionFactoryFromXml();

        // 根据factoryFromXml获取tk的configuration。tk的configuration继承了mybatis的configuration。
        Configuration tkConfiguration = ConfigurationUtil.getTkConfiguration(factoryFromXml);

        // 根据tkConfiguration来获取SqlSessionFactory
        SqlSessionFactory sessionFactory = SqlSessionFactoryUtil.getSqlSessionFactoryFromTkConfiguration(tkConfiguration);

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
