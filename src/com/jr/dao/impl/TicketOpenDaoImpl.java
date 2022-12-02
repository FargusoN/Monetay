package com.jr.dao.impl;

import com.jr.dao.ITicketOpenDao;
import com.jr.entry.Ticketopen;
import com.jr.until.DBHelper;
import com.jr.until.SqlHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketOpenDaoImpl implements ITicketOpenDao {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Ticketopen ticketopen1;
    /**
     * 获取符合条件的所有状态的开单信息（开单）
     * */
    @Override
    public List<Ticketopen> queryAllByConditions(Ticketopen ticketopen, SqlHelper sqlHelper) {
        List<Ticketopen> list=new ArrayList<>();
        try {
            con=DBHelper.getconn();
            String sql="select * from ticket_open where status=A";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                ticketopen1=new Ticketopen();
                ticketopen1.setId(rs.getInt(1));
                ticketopen1.setNo(rs.getString(2));
                ticketopen1.setEnterPriseId(rs.getString(3));
                ticketopen1.setAcquirerEnterPriseId(rs.getString(4));
                ticketopen1.setAmount(rs.getDouble(5));
                ticketopen1.setInstitutyId(rs.getInt(6));
                ticketopen1.setCreateTime(rs.getDate(7));
                ticketopen1.setExpiryTime(rs.getDate(8));
                ticketopen1.setPaymentInterestType(rs.getString(9));
                ticketopen1.setStatus(rs.getString(10));
                ticketopen1.setUplinkAddress(rs.getString(11));
                list.add(ticketopen1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,con);
        }
        return list;
    }
    /**
     * 查询符合条件的开单中的开单信息（复核）
     * */
    @Override
    public List<Ticketopen> queryAllByConditionsOnTheBill(Ticketopen ticketopen, SqlHelper sqlHelper) {
        List<Ticketopen> list=new ArrayList<>();
        try {
            con=DBHelper.getconn();
            String sql="select * from ticket_open where status=A and ticket_remark='复核'";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                ticketopen1=new Ticketopen();
                ticketopen1.setId(rs.getInt(1));
                ticketopen1.setNo(rs.getString(2));
                ticketopen1.setEnterPriseId(rs.getString(3));
                ticketopen1.setAcquirerEnterPriseId(rs.getString(4));
                ticketopen1.setAmount(rs.getDouble(5));
                ticketopen1.setInstitutyId(rs.getInt(6));
                ticketopen1.setCreateTime(rs.getDate(7));
                ticketopen1.setExpiryTime(rs.getDate(8));
                ticketopen1.setPaymentInterestType(rs.getString(9));
                ticketopen1.setStatus(rs.getString(10));
                ticketopen1.setUplinkAddress(rs.getString(11));
                list.add(ticketopen1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,con);
        }
        return list;
    }
    /**
     * 添加开单信息
     * */
    @Override
    public int insertTicket(Ticketopen ticketopen) {
        String sql="insert into ticket_open values(?,?,?,?,?,?,?,?,?,?,?.?)";
        int i=upd(sql);
        return i;
    }

    /**
     *更改列表信息
     */
    @Override
    public int upateTicketStatus(Ticketopen ticketopen) {
    String sql="update ticket_open set status=?";
    int i=upd(sql);
    return i;
    }

    /**
     *增删改通用方法
     */
    public int upd(String sql, Object... objs) {

        int num = 0;
        try {
            con = DBHelper.getconn();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                ps.setObject(i + 1, objs[i]);
            }
            num = ps.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeAll(rs, ps, con);
        }
        return num;
    }
}
