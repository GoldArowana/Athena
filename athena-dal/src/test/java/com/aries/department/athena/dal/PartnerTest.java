package com.aries.department.athena.dal;

import com.aries.department.athena.dal.exception.PageLimitException;
import com.aries.department.athena.dal.mapper.PartnerMapper;
import com.aries.department.athena.dal.po.Partner;
import com.aries.department.athena.dal.repository.PartnerRepository;
import com.aries.department.athena.dal.util.SqlSessionUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class PartnerTest {
    @Test
    public void selectTest() {
        try (SqlSession session = SqlSessionUtil.openSession("athena")) {
            // 获取Mapper
            PartnerMapper partnerMapper = session.getMapper(PartnerMapper.class);

            // 构建example
            Example example = new Example(Partner.class);
            example.createCriteria().andBetween("id", 1, 3);
            // 输出结果
            partnerMapper.selectByExampleAndRowBounds(example, new RowBounds(1, 10));
            System.out.println(partnerMapper.selectByExample(example));
        }
    }

    @Test
    public void selectAllTest() {
        try (SqlSession session = SqlSessionUtil.openSession("athena")) {
            // 获取Mapper
            PartnerMapper partnerMapper = session.getMapper(PartnerMapper.class);
            // 输出结果
            System.out.println(partnerMapper.selectAll());
        }
    }

    @Test
    public void selectByIdTest() {
        try (SqlSession session = SqlSessionUtil.openSession("athena")) {
            // 获取Mapper
            PartnerMapper partnerMapper = session.getMapper(PartnerMapper.class);
            // 输出结果
            System.out.println(partnerMapper.selectByPrimaryKey(1));
        }
    }

    @Test
    public void selectByKeywordTest() {
        try (SqlSession session = SqlSessionUtil.openSession("athena")) {
            // 获取Mapper
            PartnerMapper partnerMapper = session.getMapper(PartnerMapper.class);

            // sql
            Example example = new Example(Partner.class);
            example.selectProperties("companyName", "password")
                    .createCriteria()
                    .andEqualTo("keyword", "abc");

            // 输出结果
            System.out.println(partnerMapper.selectByExample(example));
        }
    }

    @Test
    public void selectWithPage() throws PageLimitException {
        List<Partner> partners = PartnerRepository.getPartners(1, 10);
        System.out.println(partners);
    }

    @Test
    public void addPatnerTest() {
        Partner partner = new Partner();
        partner.setCompanyId(5);
        partner.setCompanyName("公司5");
        partner.setPassword("123123");
        PartnerRepository.addPartner(partner);
    }
}
