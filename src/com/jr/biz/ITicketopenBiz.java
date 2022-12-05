package com.jr.biz;

import com.jr.entry.TicketOpen;
import com.jr.entry.User;
import com.jr.util.SqlHelper;

import java.util.List;

public interface ITicketopenBiz {
    //查询单个开单表的no编号 ,用模糊查询,使用ajax完成异步查询,(要写工具类)

    //查询所有符合条件的开单列表信息
    public List<TicketOpen> getAllTicketopenByConditions(TicketOpen ticketOpen, SqlHelper sqlHelper);

    //查询全部状态为开单中的信息
    public List<TicketOpen> getAllTicketopenByObTheBill(TicketOpen ticketOpen, SqlHelper sqlHelper);


    //插入一条Ticketopen数据
    public boolean addTicketopen(TicketOpen ticketOpen);

    //更新开单表状态
    public boolean modifyTicketopen(TicketOpen ticketOpen);

    public TicketOpen getTicketopenbyUserEnterId(User user);
}
