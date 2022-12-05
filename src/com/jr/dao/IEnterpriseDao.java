package com.jr.dao;

import com.jr.entry.Enterprise;

import java.util.List;

public interface IEnterpriseDao {

    //通过用户id查询企业信息
    Enterprise queryEnterpriseByEnterpriseID(int in);

    //查询所有企业信息
    List<Enterprise> queryAllEnterprise();

}
