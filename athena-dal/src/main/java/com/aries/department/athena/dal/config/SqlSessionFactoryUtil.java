package com.aries.department.athena.dal.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import tk.mybatis.mapper.session.Configuration;

import java.io.IOException;

public class SqlSessionFactoryUtil {
    private static final String MYBATIS_CONFIG_XML = "SqlMapConfig.xml";

    private static volatile SqlSessionFactory factoryFromXml;

    public static SqlSessionFactory getSqlSessionFactoryFromXml() throws IOException {
        if (factoryFromXml == null) {
            synchronized (SqlSessionFactoryUtil.class) {
                if (factoryFromXml == null) {
                    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
                    factoryFromXml = builder.build(Resources.getResourceAsStream(MYBATIS_CONFIG_XML));
                    return factoryFromXml;
                }
            }
        }
        return factoryFromXml;
    }

    public static SqlSessionFactory getSqlSessionFactoryFromTkConfiguration(Configuration tkConfiguration) {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = builder.build(tkConfiguration);
        return sessionFactory;
    }
}
