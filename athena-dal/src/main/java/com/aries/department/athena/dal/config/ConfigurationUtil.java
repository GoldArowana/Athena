package com.aries.department.athena.dal.config;

import org.apache.ibatis.session.SqlSessionFactory;
import tk.mybatis.mapper.session.Configuration;

import java.util.Optional;

public class ConfigurationUtil {
    public static Configuration getTkConfiguration(SqlSessionFactory factoryFromXml) {
// 新建一个configuration
        tk.mybatis.mapper.session.Configuration configuration = new tk.mybatis.mapper.session.Configuration();
        // 把SqlMapConfig.xml里的environment元素添加进来
        configuration.setEnvironment(factoryFromXml.getConfiguration().getEnvironment());
        // 把tk.mybatis的MapperHelper添加进来
        configuration.setMapperHelper(TkMapperHelperUtil.getMapperHelper(factoryFromXml));
        // 把SqlMapConfig.xml里的所有mapper，添加进来
        Optional.ofNullable(factoryFromXml.getConfiguration().getMapperRegistry().getMappers()).get()
                .forEach(configuration::addMapper);

        return configuration;
    }
}
