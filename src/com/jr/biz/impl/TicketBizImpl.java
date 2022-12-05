package com.jr.biz.impl;

import com.jr.biz.ITicketBiz;
import com.jr.dao.impl.TicketDaoImpl;
import com.jr.entry.TicketOpen;
import com.jr.util.PageHelper;

import java.util.List;

public class TicketBizImpl implements ITicketBiz {
    @Override
    //查询总页数
    public int getAllnum() {
        TicketDaoImpl ticketDao = new TicketDaoImpl();
        return ticketDao.queryCountNum();
    }

    @Override
    public List<TicketOpen> getBypage(PageHelper pageHelper) {
        TicketDaoImpl ticketDao = new TicketDaoImpl();
        return ticketDao.QueryByPage(pageHelper);
    }
}
