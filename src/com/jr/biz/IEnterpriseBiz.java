package com.jr.biz;

import com.jr.entry.Enterprise;
import com.jr.entry.TicketOpen;

import java.util.List;

public interface IEnterpriseBiz {

    //通过用户id获取企业信息
    Enterprise getInfoByEnterpriseID(int in);

    //查询所有企业信息
    List<Enterprise> getAllEnterprise();


}
