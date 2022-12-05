package com.jr.util;


public class SqlHelper {

    private String no;     //凭证编号
    private String acquirerEnterPriseId;       //收单企业id
    private String enterPriseId;        //开单企业id
    private String createTime;            //开单日期
    private String status;              //票据状态
    private String amountMax;         //最高凭证金额
    private String amountMin;         //最低凭证金额

    public SqlHelper() {
    }

    public static void main(String[] args) {
        String s = new SqlHelper("", "", "", "", "", "45", "45").sqlConcat();
        System.out.println(s);
    }
    /**
     *
     * @param no    //初始化编号
     * @param acquirerEnterPriseId      //初始化企业id
     * @param enterPriseId      //初始化开单企业id
     * @param createTime        //初始化开单日期
     * @param status            //初始化票据状态
     * @param amountMax         //初始化最高凭证金额
     * @param amountMin         //初始化最低凭证金额
     */

    public SqlHelper(String no, String acquirerEnterPriseId, String enterPriseId, String createTime, String status, String amountMax, String amountMin) {
        this.no = no;
        this.acquirerEnterPriseId = acquirerEnterPriseId;
        this.enterPriseId = enterPriseId;
        this.createTime = createTime;
        this.status = status;
        this.amountMax = amountMax;
        this.amountMin = amountMin;
    }
    /**
     *数据库查询语句，判断开单列表等下来框或者输入的数据是否为空，不为空进行拼接条件，进行查询
     */
    public String sqlConcat(){
        return ((this.no==null||this.no=="")?"":(" AND no like '%"+this.no+"%'"))+(this.acquirerEnterPriseId==null||this.acquirerEnterPriseId==""?"":" AND acquirerEnterPriseId="+this.acquirerEnterPriseId)+
                (this.enterPriseId==null||this.enterPriseId==""?"":" AND enterPriseId="+this.enterPriseId)+(this.createTime==null||this.createTime==""?"":" AND createTime="+this.createTime)+
                (this.status==null||this.status==""?"":" AND status="+this.status)+(this.amountMax==null||this.amountMax==""?"":" AND amount<="+this.amountMax)+
                (this.amountMin==null||this.amountMin==""?"":" AND amount>="+this.amountMin);
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getAcquirerEnterPriseId() {
        return acquirerEnterPriseId;
    }

    public void setAcquirerEnterPriseId(String acquirerEnterPriseId) {
        this.acquirerEnterPriseId = acquirerEnterPriseId;
    }

    public String getEnterPriseId() {
        return enterPriseId;
    }

    public void setEnterPriseId(String enterPriseId) {
        this.enterPriseId = enterPriseId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmountMax() {
        return amountMax;
    }

    public void setAmountMax(String amountMax) {
        this.amountMax = amountMax;
    }

    public String getAmountMin() {
        return amountMin;
    }

    public void setAmountMin(String amountMin) {
        this.amountMin = amountMin;
    }

    @Override
    public String toString() {
        return "SqlHelper{" +
                "no=" + no +
                ", acquirerEnterPriseId='" + acquirerEnterPriseId + '\'' +
                ", enterPriseId='" + enterPriseId + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                ", amountMax=" + amountMax +
                ", amountMin=" + amountMin +
                '}';
    }
}
