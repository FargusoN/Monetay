<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2022/12/2
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="tic" method="get">
    <input type="hidden" name="ticket" value="2"/>
    凭证信息
    开单企业
    <input type="text" name="openename" value="${viewutility.openename}"/>
    统一社会信用代码
    <input type="text" name="openescu" value="${viewutility.openescu}"/><br>
    收单企业
    <select>
        <option name="receiptename" value="baidu">百度科技有限公司</option>
        <option name="receiptename" value="jd">京东集团</option>
        <option name="receiptename" value="xm">小米</option>
    </select>
    统一社会信用代码
    <input type="text" name="receiptescu" value="${viewutility.receiptescu}"/><br>
    凭证金额
    <input type="text" name="amount" value="${viewutility.amount}"/>
    金融机构
    <select>
        <option name="institutyname" value="xy">兴业银行</option>
        <option name="institutyname" value="zg">中国银行</option>
        <option name="institutyname" value="gs">工商银行</option>
    </select><br>
    开单日期
    <input type="date" name="createTime" value="${viewutility.createTime}"/><br>
    到期日期
    <input type="date" name="expriyTime" value="${viewutility.expriyTime}"/>
    付息方式
    <select>
        <option name="paymentInterestItype" value="A">融资方付息</option>
        <option name="paymentInterestItype" value="B">核心企业付息</option>
    </select><br>
    备注
    <input type="text" name="" value="${viewutility.ticketRemark}"/>
    <input type="reset" value="取消"/>
    <input type="submit" value="提交">
</form>



</body>
</html>
