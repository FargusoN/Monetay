package com.jr.servelet;

import com.google.gson.Gson;
import com.jr.biz.impl.TicketopenBizImpl;
import com.jr.entry.Ticketopen;
import com.jr.until.PageHelper;
import com.jr.until.SqlHelper;
import com.sun.xml.internal.bind.v2.model.core.ID;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/ss")
public class
TicketOpenServlet extends HttpServlet {
    TicketopenBizImpl ticketopenBiz=new TicketopenBizImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        page(request,response);
    }

    /**
     * 分页，每隔5页换一篇
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String no = request.getParameter("no");
        String acquirerEnterPriseId=request.getParameter("acquirerEnterPriseId");
        String enterPriseId=request.getParameter("enterPriseId");
        String createTime=request.getParameter("createTime");
        String status=request.getParameter("status");
        String amountMax=request.getParameter("amountMax");
        String amountMin=request.getParameter("amountMin");
        SqlHelper sqlHelper = new SqlHelper();
        sqlHelper.setNo(no);
        sqlHelper.setAcquirerEnterPriseId(acquirerEnterPriseId);
        sqlHelper.setEnterPriseId(enterPriseId);
        sqlHelper.setCreateTime(createTime);
        sqlHelper.setStatus(status);
        sqlHelper.setAmountMax(amountMax);
        sqlHelper.setAmountMin(amountMin);
        PageHelper<Ticketopen> ph=new PageHelper<>();
        ph.setTotalCount(ticketopenBiz.getAllnum(sqlHelper));
        ph.setPageSize(5);
        ph.getTotalPage();

        String str=request.getParameter("index");
        if(str==null){
            ph.setIndexPage(1);
        }else{
            int i=Integer.parseInt(str);
            ph.setIndexPage(i);
        }
        ph.setPageList(ticketopenBiz.getBypage(ph,sqlHelper));
        Gson gson = new Gson();
        response.getWriter().println( gson.toJson(ph));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("我爱坤坤");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    /**
     * 获取所有ticketopen开单表中的信息
     */
    protected void getAllTicketopeninfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String no = request.getParameter("no");
        String acquirerEnterPriseId=request.getParameter("acquirerEnterPriseId");
        String enterPriseId=request.getParameter("enterPriseId");
        String createTime=request.getParameter("createTime");
        String status=request.getParameter("status");
        String amountMax=request.getParameter("amountMax");
        String amountMin=request.getParameter("amountMin");
        SqlHelper sqlHelper = new SqlHelper();
        Ticketopen ticketopen=new Ticketopen();
        sqlHelper.setNo(no);
        sqlHelper.setAcquirerEnterPriseId(acquirerEnterPriseId);
        sqlHelper.setEnterPriseId(enterPriseId);
        sqlHelper.setCreateTime(createTime);
        sqlHelper.setStatus(status);
        sqlHelper.setAmountMax(amountMax);
        sqlHelper.setAmountMin(amountMin);
        PageHelper pageHelper1=new PageHelper();
        pageHelper1.setIndexPage(1);
        pageHelper1.setPageSize(5);
        pageHelper1.setTotalCount(ticketopenBiz.getAllnum(sqlHelper));
        pageHelper1.setPageList(ticketopenBiz.getAllByConditionsOnTheBill(ticketopen,sqlHelper));

        Gson gson=new Gson();

        response.getWriter().println(gson.toJson(pageHelper1));

    }
/**
 * 获取所有符合条件的ticketopen开单表信息
 * 这里使用前台异步查询,提供了字符串拼接工具类
 * 可以直接在里边拼接所需要属性的字符串
 * */
    protected void getTicketopeninfoByconditions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * 根据id修改状态
     * */
    protected void getalertTicketStatusbyid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        Ticketopen ticketopen = new Ticketopen();
        String status=request.getParameter("status");
        ticketopen.setStatus(status);
        //判断是否有修改行
        if (ticketopenBiz.upateTicketStatus(ticketopen)!=0){

            getAllTicketopeninfo(request,response);
            //修改成功再次展示页面
        }else{

            getAllTicketopeninfo(request,response);
            //修改失败也再次展示页面
        }

    }

}
