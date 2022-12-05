package com.jr.biz;

import com.jr.entry.Reviewrecord;

import java.util.List;

public interface IReviewrecordBiz {
    /**
     * 添加审核记录，每审核一个ticket_open表单信息，就要将信息插入到review_record表中
     */
    int addReviewrecord(Reviewrecord reviewrecord);

    /**
     * 获取指定开单信息集合，将所有数据展示到页面中
     * 注：此处可使用review_record的ticket_open_id来锁定ticket_open表
     * 多表联查锁定ticket_open中的开单企业和收单企业
     * 以上sql为一句话
     */
    List<Reviewrecord> getReviewrecord(int ticketId);

}
