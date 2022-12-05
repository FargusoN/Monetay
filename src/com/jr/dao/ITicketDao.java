package com.jr.dao;

import com.jr.entry.TicketOpen;
import com.jr.util.PageHelper;

import java.util.List;

public interface ITicketDao {
    public int queryCountNum(); //查询全部数据条数

    public List<TicketOpen> QueryByPage(PageHelper pageHelper); //查询分页信息集合

}
