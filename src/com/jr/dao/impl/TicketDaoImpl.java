package com.jr.dao.impl;

import com.jr.dao.ITicketDao;
import com.jr.entry.TicketOpen;
import com.jr.util.DBHelper;
import com.jr.util.PageHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TicketDaoImpl implements ITicketDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public int queryCountNum() {
        int num=0;
        try {
            con=DBHelper.getconn();
            String sql="select count(no) from ticketlist ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()){
                num=rs.getInt(1);
            }

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
    public List<TicketOpen> QueryByPage(PageHelper pageHelper) {
        List<TicketOpen> list = new ArrayList<>();
        try {
            con = DBHelper.getconn();
            String sql = "select * from ticketlist";
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            while (rs.next()){
                TicketOpen ticketOpen1=new TicketOpen();
                ticketOpen1.setId(rs.getInt("id"));
                ticketOpen1.setNo(rs.getString("no"));
                ticketOpen1.setEnterPriseId(rs.getString("enterprise_id"));
                ticketOpen1.setAcquirerEnterPriseId(rs.getString("acquirer_enterprise_id"));
                ticketOpen1.setAmount(rs.getDouble("amount"));
                ticketOpen1.setInstitutyId(rs.getInt("instituty_id"));
                ticketOpen1.setCreateTime(simpleDateFormat.parse(rs.getString("create_time")));
                ticketOpen1.setExpiryTime(simpleDateFormat.parse(rs.getString("expiry_time")));
                ticketOpen1.setPaymentInterestType(rs.getString("payment_interest_type"));
                ticketOpen1.setStatus(rs.getString("status"));
                ticketOpen1.setUplinkAddress(rs.getString("uplink_address"));
                ticketOpen1.setTicket_remark(rs.getString("ticket_remark"));
                list.add(ticketOpen1);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally{
            DBHelper.closeAll(rs,ps,con);
        }

        return list;
    }
}
