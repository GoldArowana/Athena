package com.aries.department.athena.service.thrift;

import com.alibaba.fastjson.JSON;
import com.aries.department.athena.contract.thrift.dto.CompanyInfo;
import com.aries.department.athena.contract.thrift.service.DailySignService;
import com.aries.department.athena.dal.repository.DailyRepository;
import com.aries.department.athena.service.thrift.util.CompanyHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;

import java.util.Date;
import java.util.List;

@Slf4j
public class DailySignServiceImpl implements DailySignService.Iface {
    @Override
    public String ping() throws TException {
        log.debug("[pong- -.]");
        return "pong, i am daily sign service";
    }

    @Override
    public boolean addSignNow(CompanyInfo companyInfo, long staffId) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError()) {
            log.warn("addSignNow 没有权限,companyDTO:{}, staffId:{}", JSON.toJSONString(companyInfo), staffId);
            throw new TException("解析公司错误:" + JSON.toJSONString(companyInfo));
        }
        return DailyRepository.addSignNow(companyHelper.getDatabaseName(), staffId);
    }

    @Override
    public boolean hasSigned(CompanyInfo companyInfo, long staffId, long startTimeMills, long endTimeMills) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError()) {
            log.warn("addSignNow 没有权限,companyDTO:{}, staffId:{}", JSON.toJSONString(companyInfo), staffId);
            throw new TException("解析公司错误:" + JSON.toJSONString(companyInfo));
        }
        return DailyRepository.hasSigned(companyHelper.getDatabaseName(), staffId, new Date(startTimeMills), new Date(endTimeMills));
    }

    @Override
    public boolean signNowIfNotSignedInPeriod(CompanyInfo companyInfo, long staffId, long startTimeMills, long endTimeMills) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError()) {
            log.warn("addSignNow 没有权限,companyDTO:{}, staffId:{}", JSON.toJSONString(companyInfo), staffId);
            throw new TException("解析公司错误:" + JSON.toJSONString(companyInfo));
        }

        boolean hasSigned = DailyRepository.hasSigned(companyHelper.getDatabaseName(), staffId, new Date(startTimeMills), new Date(endTimeMills));
        if (hasSigned) {
            return false;
        }

        return DailyRepository.addSignNow(companyHelper.getDatabaseName(), staffId);
    }

    @Override
    public List<Long> getSignList(CompanyInfo companyInfo, long staffId, long startTimeMills, long endTimeMills) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError()) {
            log.warn("addSignNow 没有权限,companyDTO:{}, staffId:{}", JSON.toJSONString(companyInfo), staffId);
            throw new TException("解析公司错误:" + JSON.toJSONString(companyInfo));
        }
        return DailyRepository.getSignList(companyHelper.getDatabaseName(), staffId, new Date(startTimeMills), new Date(endTimeMills));
    }


}
