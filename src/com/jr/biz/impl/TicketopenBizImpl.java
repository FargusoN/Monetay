package com.jr.biz.impl;

import com.jr.biz.ITicketopenBiz;
import com.jr.dao.impl.TicketOpenDaoImpl;
import com.jr.entry.Ticketopen;
import com.jr.until.SqlHelper;

import java.util.List;

public class TicketopenBizImpl implements ITicketopenBiz {
    /**
     * 获取符合条件的所有状态的开单信息（开单）
     * */
    TicketOpenDaoImpl tic=new TicketOpenDaoImpl();

    @Override
    public List<Ticketopen> getAllByConditions(Ticketopen ticketopen, SqlHelper sqlHelper) {
       return tic.queryAllByConditions(ticketopen,sqlHelper);
    }
    /**
     * 获取符合条件的开单中的开单信息（复核）
     * */
    @Override
    public List<Ticketopen> getAllByConditionsOnTheBill(Ticketopen ticketopen, SqlHelper sqlHelper) {
        return tic.queryAllByConditions(ticketopen,sqlHelper);

    }
    /**
     * 添加开单信息
     * */
    @Override
    public int addTicket(Ticketopen ticketopen) {
        return tic.insertTicket(ticketopen);

    }
    /**
     *更改开单数据信息
     */
    @Override
    public int upateTicketStatus(Ticketopen ticketopen) {
        return tic.upateTicketStatus(ticketopen);
    }
}
