package com.jr.dao.impl;

import com.jr.dao.ITicketOpenDao;
import com.jr.entry.TicketOpen;
import com.jr.entry.User;
import com.jr.util.DBHelper;
import com.jr.util.SqlHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TicketOpenDaoImpl implements ITicketOpenDao {
    //查询单个开单表的no编号 ,用模糊查询,使用ajax完成异步查询,(要写工具类)
    //查询所有符合条件的开单列表信息
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public List<TicketOpen> queryAllTicketopenByConditions(TicketOpen ticketOpen, SqlHelper sqlHelper) {
        List<TicketOpen> ticketOpens = new ArrayList<>();

        try {
            con = DBHelper.getconn();
            String sql = "select * from ticket_open where id is not null" + sqlHelper.sqlConcat();
            ps = con.prepareStatement(sql);
            rs = this.ps.executeQuery();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            while (rs.next()) {
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
                 ticketOpens.add(ticketOpen1);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            DBHelper.closeAll(rs, ps, con);
        }

        return ticketOpens;
    }

    @Override
    public List<TicketOpen> QueryAllTicketopenByObTheBill(TicketOpen ticketOpen) {
        List<TicketOpen> ticketOpens = new ArrayList<>();

        try {
            con = DBHelper.getconn();
            String sql = "select * from ticket_open where  status='开单中' ";
            ps = con.prepareStatement(sql);
            rs = this.ps.executeQuery();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            while (rs.next()) {
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
                ticketOpens.add(ticketOpen1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            DBHelper.closeAll(rs, ps, con);
        }
        return ticketOpens;
    }


    //    插入一条Ticketopen数据
    @Override
    public int insertTicketopen(TicketOpen ticketOpen) {
        int i;
        try {
            con = DBHelper.getconn();
            String sql = "insert into ticket_open  values (null,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, ticketOpen.getNo());
            ps.setString(2, ticketOpen.getEnterPriseId());
            ps.setString(3, ticketOpen.getAcquirerEnterPriseId());
            ps.setDouble(4, ticketOpen.getAmount());
            ps.setInt(5, ticketOpen.getInstitutyId());
            ps.setString(6, new SimpleDateFormat("yyyy-MM-dd").format(ticketOpen.getCreateTime()));
            ps.setString(7, new SimpleDateFormat("yyyy-MM-dd").format(ticketOpen.getExpiryTime()));
            ps.setString(8, ticketOpen.getPaymentInterestType());
            ps.setString(9, ticketOpen.getStatus());
            ps.setString(10, ticketOpen.getUplinkAddress());
            ps.setString(11, ticketOpen.getTicket_remark());

            i = ps.executeUpdate();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBHelper.closeAll(rs, ps, con);
        }

        System.out.println("++++++++++++++++++++++++++++++++++"+i);
        return i;
    }
    /*

     */

    @Override
    public int updateTicketopen(TicketOpen ticketOpen) {
        int i;
        try {
            con = DBHelper.getconn();
            String sql = "update ticket_open set";
            ps = con.prepareStatement(sql);
            ps.setString(1, ticketOpen.getNo());
            ps.setString(2, ticketOpen.getEnterPriseId());
            ps.setString(3, ticketOpen.getAcquirerEnterPriseId());
            ps.setDouble(4, ticketOpen.getAmount());
            ps.setInt(5, ticketOpen.getInstitutyId());
            ps.setString(6, new SimpleDateFormat("yyyy-MM-dd").format(ticketOpen.getCreateTime()));
            ps.setString(7, new SimpleDateFormat("yyyy-MM-dd").format(ticketOpen.getExpiryTime()));
            ps.setString(8, ticketOpen.getPaymentInterestType());
            ps.setString(9, ticketOpen.getStatus());
            ps.setString(10, ticketOpen.getUplinkAddress());
            ps.setString(11, ticketOpen.getTicket_remark());

            i = ps.executeUpdate();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBHelper.closeAll(rs, ps, con);
        }
        return i;
    }

    @Override
    public TicketOpen selectTicketopenbyUserEnterId(User user) {
        TicketOpen t = null;
        try {
            con = DBHelper.getconn();
            String sql = "select * from ticket_open where id =?";
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getEnterPriseId());
            rs = ps.executeQuery();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (rs.next()) {
                t = new TicketOpen(
                        rs.getInt("id"),
                        rs.getString("no"),
                        rs.getString("enterprise_id"),
                        rs.getString("acquirer_enterprise_id"),
                        rs.getDouble("amount"),
                        rs.getInt("instituty_id"),
                        simpleDateFormat.parse(rs.getString("create_time")),
                        simpleDateFormat.parse(rs.getString("expiry_time")),
                        rs.getString("payment_interest_type"),
                        rs.getString("status"),
                        rs.getString("uplink_address"),
                        rs.getString("ticket_remark")
                );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            DBHelper.closeAll(rs, ps, con);
        }

        return t;
    }
}

