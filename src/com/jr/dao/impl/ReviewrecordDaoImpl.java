package com.jr.dao.impl;

import com.jr.dao.IReviewrecordDao;
import com.jr.entry.Reviewrecord;
import com.jr.util.DBHelper;
import com.jr.util.ViewUtility;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ReviewrecordDaoImpl implements IReviewrecordDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public int insertReviewrecord(Reviewrecord reviewrecord) {
        int num = 0;
        try {
            con = DBHelper.getconn();
            String sql = "insert into review_record values(null,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, reviewrecord.getTicketOpenId());
            ps.setInt(2, reviewrecord.getCreatorId());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ps.setString(3, dateFormat.format(reviewrecord.getCreateTime()));
            ps.setString(4, reviewrecord.getReviewStatus());
            ps.setString(5, reviewrecord.getRemark());
            num = ps.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return num;


    }

    @Override
    public List<Reviewrecord> queryReviewrecordByTicketId(int ticketId) {
        List<Reviewrecord> list = new ArrayList<>();


        return list;
    }
}
