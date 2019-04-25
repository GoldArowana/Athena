package com.aries.department.athena.dal.repository;

import com.aries.department.athena.dal.exception.PageLimitException;
import com.aries.department.athena.dal.mapper.PartnerMapper;
import com.aries.department.athena.dal.po.Partner;
import com.aries.department.athena.dal.util.SqlSessionUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import tk.mybatis.mapper.entity.Example;

import java.util.Collections;
import java.util.List;

public class PartnerRepository {
    private static final String PARTNER_DB = "athena";

    /**
     * 分页查询合作公司信息
     *
     * @param page     页码，必须大于等于1.
     * @param pageSize 每页的大小。值不能大于100.
     * @throws PageLimitException
     */
    public static List<Partner> getPartners(int page, int pageSize) throws PageLimitException {
        if (page < 1 || pageSize > 100) {
            throw new PageLimitException("page必须大于等于1，且pageSize不能大于100");
        }

        try (SqlSession session = SqlSessionUtil.openSession(PARTNER_DB)) {
            // 获取Mapper
            PartnerMapper partnerMapper = session.getMapper(PartnerMapper.class);

            // 构建example
            Example example = new Example(Partner.class);

            int offset = (page - 1) * pageSize;
            int limit = pageSize;
            List<Partner> partners = partnerMapper.selectByExampleAndRowBounds(example, new RowBounds(offset, limit));

            if (CollectionUtils.isNotEmpty(partners)) {
                return partners;
            }
        }
        return Collections.emptyList();
    }


    public static boolean addPartner(Partner partner) {
        try (SqlSession session = SqlSessionUtil.openSession(PARTNER_DB)) {
            // 获取Mapper
            PartnerMapper partnerMapper = session.getMapper(PartnerMapper.class);

            int effective = partnerMapper.insertSelective(partner);

            return effective > 0;
        }
    }

}
