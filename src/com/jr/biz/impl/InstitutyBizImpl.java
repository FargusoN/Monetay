package com.jr.biz.impl;

import com.jr.biz.IInstitutyBiz;
import com.jr.dao.impl.InstitutyDaoImpl;
import com.jr.entry.Instituty;

import java.util.ArrayList;
import java.util.List;

public class InstitutyBizImpl implements IInstitutyBiz {
    InstitutyDaoImpl institutyDao = new InstitutyDaoImpl();
    @Override
    public List<Instituty> getAllInstituty() {
        return institutyDao.queryAllInstituty();
    }
}
