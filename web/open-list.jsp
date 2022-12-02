<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2022/12/2
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--付款列表--%>
凭证编号
<input type="text" name="openename" value="${SqlHelper.no}"/>
收单企业
<select>
    <option name="receiptename" value="baidu">百度科技有限公司</option>
    <option name="receiptename" value="jd">京东集团</option>
    <option name="receiptename" value="xm">小米</option>
</select>
开单企业
<select>
    <option name="" value="">腾讯科技有限公司</option>
    <option name="" value="">腾讯科技有限公司</option>
</select>
开单日期
处理状态
凭证金额
</body>
</html>
