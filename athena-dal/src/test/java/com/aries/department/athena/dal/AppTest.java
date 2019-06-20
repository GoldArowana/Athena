package com.aries.department.athena.dal;

import com.aries.department.athena.dal.mapper.StuMapper;
import com.aries.department.athena.dal.po.Stu;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Unit test for simple TkMapperTest.
 */
public class AppTest {
    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        sqlSession = factory.openSession();
    }

    @Test
    public void selectUserById2() throws IOException {
        StuMapper mapper = sqlSession.getMapper(StuMapper.class);
        Stu partner = mapper.getStuById(1);
        System.out.println(partner);
    }

    @After
    public void close() {
        sqlSession.close();
    }
}
