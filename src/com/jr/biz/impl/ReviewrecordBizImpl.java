package com.jr.biz.impl;

import com.jr.biz.IReviewrecordBiz;
import com.jr.dao.impl.ReviewrecordDaoImpl;
import com.jr.entry.Reviewrecord;

import java.util.List;

public class ReviewrecordBizImpl implements IReviewrecordBiz {
    @Override
    public int addReviewrecord(Reviewrecord reviewrecord) {
        ReviewrecordDaoImpl reviewrecordDao = new ReviewrecordDaoImpl();
        return reviewrecordDao.insertReviewrecord(reviewrecord);
    }

    @Override
    public List<Reviewrecord> getReviewrecord(int ticketId) {
        return null;
    }
}
