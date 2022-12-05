package com.jr.dao;

import com.jr.entry.Reviewrecord;

import java.util.List;

public interface IReviewrecordDao {

    int insertReviewrecord(Reviewrecord reviewrecord);

//查找审核记录
    List<Reviewrecord> queryReviewrecordByTicketId(int ticketId);



}
