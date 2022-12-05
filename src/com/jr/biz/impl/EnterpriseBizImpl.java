package com.jr.biz.impl;

import com.jr.biz.IEnterpriseBiz;
import com.jr.dao.impl.EnterpriseDaoImpl;
import com.jr.entry.Enterprise;
import com.jr.util.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnterpriseBizImpl implements IEnterpriseBiz {
    EnterpriseDaoImpl enterpriseDao = new EnterpriseDaoImpl();
    Enterprise enterprise = new Enterprise();

    @Override
    public Enterprise getInfoByEnterpriseID(int in) {
        return enterpriseDao.queryEnterpriseByEnterpriseID(in);
    }

    @Override
    public List<Enterprise> getAllEnterprise() {
        return enterpriseDao.queryAllEnterprise();

    }
}
