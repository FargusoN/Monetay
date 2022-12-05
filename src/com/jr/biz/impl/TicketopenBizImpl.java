package com.jr.biz.impl;

import com.jr.biz.ITicketopenBiz;
import com.jr.dao.impl.TicketOpenDaoImpl;
import com.jr.entry.TicketOpen;
import com.jr.entry.User;
import com.jr.util.SqlHelper;

import java.util.List;

public class TicketopenBizImpl implements ITicketopenBiz {
    TicketOpenDaoImpl ticketOpenDao = new TicketOpenDaoImpl();



    @Override
    public List<TicketOpen> getAllTicketopenByConditions(TicketOpen ticketOpen, SqlHelper sqlHelper) {

        List<TicketOpen> ticketOpens = ticketOpenDao.queryAllTicketopenByConditions(ticketOpen, sqlHelper);
        return ticketOpens;
    }

    @Override
    public List<TicketOpen> getAllTicketopenByObTheBill(TicketOpen ticketOpen, SqlHelper sqlHelper) {
        List<TicketOpen> ticketOpens = ticketOpenDao.QueryAllTicketopenByObTheBill(ticketOpen);
        return ticketOpens;
    }

    @Override
    public boolean addTicketopen(TicketOpen ticketOpen) {
        int i = ticketOpenDao.insertTicketopen(ticketOpen);
        return i==0?false:true;

    }

    @Override
    public boolean modifyTicketopen(TicketOpen ticketOpen) {
        return ticketOpenDao.updateTicketopen(ticketOpen)==0?false:true;
    }
    @Override
    public TicketOpen getTicketopenbyUserEnterId(User user) {
        TicketOpen ticketOpen = ticketOpenDao.selectTicketopenbyUserEnterId(user);
        return  ticketOpen;
    }
}
