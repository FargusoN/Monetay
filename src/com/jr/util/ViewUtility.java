package com.jr.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewUtility {

    private String ticket_id;
    private String no;
    private String status;
    private String openticketenterpreaseId;
    private String openename;//开单企业
    private String openesuc;//开单企业统一社会信用码
    private String receiptenterpreaseId;
    private String receiptename;//收单企业
    private String receiptesuc;//
    private String amount;
    private String instituty_id;
    private String institutyname;//金融机构
    private String createTime;
    private String expriyTime;
    private String paymentInterestItype;
    private String ticketRemark;
    private String reviewCecordRemark;

    public ViewUtility slectInfoView(String no) {
        ViewUtility viewUtility1 = null;
        Connection getconn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            getconn = DBHelper.getconn();
            String sql = "select * from infoview where  no=?";
            preparedStatement = getconn.prepareStatement(sql);
            preparedStatement.setString(1, no);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                viewUtility1 = new ViewUtility(
                        resultSet.getString("ticket_id"),
                        resultSet.getString("no"),
                        resultSet.getString("status"),
                        resultSet.getString("openticketenterpreaseId"),
                        resultSet.getString("openename"),
                        resultSet.getString("openesuc"),
                        resultSet.getString("receiptenterpreaseId"),
                        resultSet.getString("receiptename"),
                        resultSet.getString("receiptesuc"),
                        resultSet.getString("amount"),
                        resultSet.getString("instituty_id"),
                        resultSet.getString("institutyname"),
                        resultSet.getString("create_time"),
                        resultSet.getString("expiry_time"),
                        resultSet.getString("payment_interest_type"),
                        resultSet.getString("ticket_remark"),
                        resultSet.getString("review_record_remark")

                );
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
        return viewUtility1;
    }

    /*CREATE view infoview as
( select ti.id ticket_id,ti.no,ti.`status`, e1.name openename,e1.social_uniform_code openesuc
,e2.name receiptename,e2.social_uniform_code receiptesuc,ti.amount,ins.`name` institutyname,ti.create_time,ti.expiry_time,ti.payment_interest_type,
ti.ticket_remark ,re.remark review_record_remark
from review_record re inner join ticket_open ti on re.ticket_open_id=ti.id inner join enterprise e1 on ti.enterprise_id=e1.id  inner join enterprise e2 on ti.acquirer_enterprise_id=e2.id inner join instituty ins on ins.id=ti.instituty_id)
*/

    public ViewUtility(String ticket_id, String no, String status, String openticketenterpreaseId,
                       String openename, String openesuc, String receiptenterpreaseId, String receiptename,
                       String receiptesuc, String amount, String instituty_id, String institutyname,
                       String createTime, String expriyTime, String paymentInterestItype,
                       String ticketRemark, String reviewCecordRemark) {
        this.ticket_id = ticket_id;
        this.no = no;
        this.status = status;
        this.openticketenterpreaseId = openticketenterpreaseId;
        this.openename = openename;
        this.openesuc = openesuc;
        this.receiptenterpreaseId = receiptenterpreaseId;
        this.receiptename = receiptename;
        this.receiptesuc = receiptesuc;
        this.amount = amount;
        this.instituty_id = instituty_id;
        this.institutyname = institutyname;
        this.createTime = createTime;
        this.expriyTime = expriyTime;
        this.paymentInterestItype = paymentInterestItype;
        this.ticketRemark = ticketRemark;
        this.reviewCecordRemark = reviewCecordRemark;
    }

    public ViewUtility() {
    }

    public String getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOpenticketenterpreaseId() {
        return openticketenterpreaseId;
    }

    public void setOpenticketenterpreaseId(String openticketenterpreaseId) {
        this.openticketenterpreaseId = openticketenterpreaseId;
    }

    public String getOpenename() {
        return openename;
    }

    public void setOpenename(String openename) {
        this.openename = openename;
    }

    public String getOpenesuc() {
        return openesuc;
    }

    public void setOpenesuc(String openesuc) {
        this.openesuc = openesuc;
    }

    public String getReceiptenterpreaseId() {
        return receiptenterpreaseId;
    }

    public void setReceiptenterpreaseId(String receiptenterpreaseId) {
        this.receiptenterpreaseId = receiptenterpreaseId;
    }

    public String getReceiptename() {
        return receiptename;
    }

    public void setReceiptename(String receiptename) {
        this.receiptename = receiptename;
    }

    public String getReceiptesuc() {
        return receiptesuc;
    }

    public void setReceiptesuc(String receiptesuc) {
        this.receiptesuc = receiptesuc;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getInstituty_id() {
        return instituty_id;
    }

    public void setInstituty_id(String instituty_id) {
        this.instituty_id = instituty_id;
    }

    public String getInstitutyname() {
        return institutyname;
    }

    public void setInstitutyname(String institutyname) {
        this.institutyname = institutyname;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getExpriyTime() {
        return expriyTime;
    }

    public void setExpriyTime(String expriyTime) {
        this.expriyTime = expriyTime;
    }

    public String getPaymentInterestItype() {
        return paymentInterestItype;
    }

    public void setPaymentInterestItype(String paymentInterestItype) {
        this.paymentInterestItype = paymentInterestItype;
    }

    public String getTicketRemark() {
        return ticketRemark;
    }

    public void setTicketRemark(String ticketRemark) {
        this.ticketRemark = ticketRemark;
    }

    public String getReviewCecordRemark() {
        return reviewCecordRemark;
    }

    public void setReviewCecordRemark(String reviewCecordRemark) {
        this.reviewCecordRemark = reviewCecordRemark;
    }

    @Override
    public String toString() {
        return "ViewUtility{" +
                "ticket_id='" + ticket_id + '\'' +
                ", no='" + no + '\'' +
                ", status='" + status + '\'' +
                ", openticketenterpreaseId='" + openticketenterpreaseId + '\'' +
                ", openename='" + openename + '\'' +
                ", openesuc='" + openesuc + '\'' +
                ", receiptenterpreaseId='" + receiptenterpreaseId + '\'' +
                ", receiptename='" + receiptename + '\'' +
                ", receiptesuc='" + receiptesuc + '\'' +
                ", amount='" + amount + '\'' +
                ", instituty_id='" + instituty_id + '\'' +
                ", institutyname='" + institutyname + '\'' +
                ", createTime='" + createTime + '\'' +
                ", expriyTime='" + expriyTime + '\'' +
                ", paymentInterestItype='" + paymentInterestItype + '\'' +
                ", ticketRemark='" + ticketRemark + '\'' +
                ", reviewCecordRemark='" + reviewCecordRemark + '\'' +
                '}';
    }


    //传凭证编号

}
