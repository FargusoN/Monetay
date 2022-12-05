package com.jr.biz;

import com.jr.entry.TicketOpen;
import com.jr.util.PageHelper;

import java.util.List;

public interface ITicketBiz {
    public int getAllnum();
    //当前页面的信息
    public List<TicketOpen> getBypage(PageHelper pageHelper);

}
