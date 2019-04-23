package com.aries.department.athena.dal;

import com.aries.department.athena.dal.mapper.StuMapper;
import com.aries.department.athena.dal.po.Stu;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        SqlSession sqlSession = factory.openSession();
        StuMapper mapper = sqlSession.getMapper(StuMapper.class);
        Stu stu = mapper.getStuById(1);
        System.out.println(stu);
        sqlSession.close();
    }
}
