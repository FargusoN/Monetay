package com.jr.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketView {
    private String no;
    private String enterPriseId;
    private String enp1name;
    private String amount;
    private String acquirerEnterPriseId;
    private String enp2name;
    private String insname;
    private String createTime;
    private String expiryTime;
    private String uplink_address;
    private String status;

    public TicketView() {
    }

    public TicketView(String no, String enterPriseId, String enp1name,
                      String amount, String acquirerEnterPriseId,
                      String enp2name, String insname, String createTime,
                      String expiryTime, String uplink_address, String status) {
        this.no = no;
        this.enterPriseId = enterPriseId;
        this.enp1name = enp1name;
        this.amount = amount;
        this.acquirerEnterPriseId = acquirerEnterPriseId;
        this.enp2name = enp2name;
        this.insname = insname;
        this.createTime = createTime;
        this.expiryTime = expiryTime;
        this.uplink_address = uplink_address;
        this.status = status;
    }

    @Override
    public String toString() {
        return "TicketView{" +
                "no='" + no + '\'' +
                ", enterPriseId='" + enterPriseId + '\'' +
                ", enp1name='" + enp1name + '\'' +
                ", amount='" + amount + '\'' +
                ", acquirerEnterPriseId='" + acquirerEnterPriseId + '\'' +
                ", enp2name='" + enp2name + '\'' +
                ", insname='" + insname + '\'' +
                ", createTime='" + createTime + '\'' +
                ", expiryTime='" + expiryTime + '\'' +
                ", uplink_address='" + uplink_address + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEnterPriseId() {
        return enterPriseId;
    }

    public void setEnterPriseId(String enterPriseId) {
        this.enterPriseId = enterPriseId;
    }

    public String getEnp1name() {
        return enp1name;
    }

    public void setEnp1name(String enp1name) {
        this.enp1name = enp1name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAcquirerEnterPriseId() {
        return acquirerEnterPriseId;
    }

    public void setAcquirerEnterPriseId(String acquirerEnterPriseId) {
        this.acquirerEnterPriseId = acquirerEnterPriseId;
    }

    public String getEnp2name() {
        return enp2name;
    }

    public void setEnp2name(String enp2name) {
        this.enp2name = enp2name;
    }

    public String getInsname() {
        return insname;
    }

    public void setInsname(String insname) {
        this.insname = insname;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getUplink_address() {
        return uplink_address;
    }

    public void setUplink_address(String uplink_address) {
        this.uplink_address = uplink_address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static void main(String[] args) {
        List<TicketView> ticketViews = new TicketView().selectAll();
        for (TicketView ticketView : ticketViews) {
            System.out.println(ticketView);
        }
    }

    public List<TicketView> selectAll() {
        List<TicketView> ticketViews = new ArrayList<>();
        TicketView ticketView1;
        Connection getconn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            getconn = DBHelper.getconn();
            String sql = "select * from ticketlist";
            preparedStatement = getconn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ticketView1 = new TicketView(
                        resultSet.getString("no"),
                        resultSet.getString("enterPriseId"),
                        resultSet.getString("enp1name"),
                        resultSet.getString("amount"),
                        resultSet.getString("acquirerEnterPriseId"),
                        resultSet.getString("enp2name"),
                        resultSet.getString("insname"),
                        resultSet.getString("createTime"),
                        resultSet.getString("expiryTime"),
                        resultSet.getString("uplink_address"),
                        resultSet.getString("status"));
                ticketViews.add(ticketView1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBHelper.closeAll(resultSet, preparedStatement, getconn);
        }
        return ticketViews;
    }

    public List<TicketView> selectAllByConnditions(SqlHelper sqlHelper) {
        List<TicketView> ticketViews = new ArrayList<>();
        TicketView ticketView1;
        Connection getconn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            getconn = DBHelper.getconn();
            String sql = "select * from ticketlist where  no!=0 " + sqlHelper.sqlConcat();
            System.out.println(sql);
            preparedStatement = getconn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ticketView1 = new TicketView(
                        resultSet.getString("no"),
                        resultSet.getString("enterPriseId"),
                        resultSet.getString("enp1name"),
                        resultSet.getString("amount"),
                        resultSet.getString("acquirerEnterPriseId"),
                        resultSet.getString("enp2name"),
                        resultSet.getString("insname"),
                        resultSet.getString("createTime"),
                        resultSet.getString("expiryTime"),
                        resultSet.getString("uplink_address"),
                        resultSet.getString("status"));
                ticketViews.add(ticketView1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBHelper.closeAll(resultSet, preparedStatement, getconn);
        }
        return ticketViews;
    }
}
