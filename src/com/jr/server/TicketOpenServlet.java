package com.jr.server;

import com.google.gson.Gson;
import com.jr.biz.impl.TicketBizImpl;
import com.jr.biz.impl.TicketopenBizImpl;
import com.jr.entry.TicketOpen;
import com.jr.entry.User;
import com.jr.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all"})
@WebServlet("/ticketopentservlet")
public class TicketOpenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        if (request.getParameter("ticketopentservletstate").equals("1")) {
            getTicketopenByTicketView(request, response);

    }
        if (request.getParameter("ticketopentservletstate").equals("2")) {
            getTicketInfoView(request, response);
        }

        if (request.getParameter("ticketopentservletstate").equals("3")) {
            getTicketopenByTicketViewForconditions(request, response);
        }
        if (request.getParameter("ticketopentservletstate").equals("4")) {
            getTicketopenByTicketViewForconditions2(request, response);
        }

        if (request.getParameter("ticketopentservletstate").equals("5")) {
            getAllEsuc(request, response);
        }
        if (request.getParameter("ticketopentservletstate").equals("6")) {
            addTicketopeninfo(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
 /*       if (request.getParameter("ticketopentservletstate").equals("0")) {
            getAllTicketopeninfo(request, response);

        }
        if (request.getParameter("ticketopentservletstate").equals("1")) {
            addTicketopeninfo(request, response);
        }

        if (request.getParameter("ticketopentservletstate").equals("2")) {
            addTicketopeninfo(request, response);
        }
        if (request.getParameter("ticketopentservletstate").equals("3")) {
            addTicketopeninfo(request, response);
        }*/

    }




    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    /**
     * 获取所有ticketopen开单表中的信息
     */
    protected void getAllTicketopeninfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TicketOpen ticketOpen = new TicketOpen();
        SqlHelper sqlHelper = new SqlHelper();
        List<TicketOpen> allTicketopen = new TicketopenBizImpl().getAllTicketopenByConditions(ticketOpen, sqlHelper);
        response.getWriter().println(new Gson().toJson(allTicketopen));
    }


    /**
     * 获取所有符合条件的ticketopen开单表信息
     * 这里使用前台异步查询,提供了字符串拼接工具类
     * 可以直接在里边拼接所需要属性的字符串
     */

    protected void addTicketopeninfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


            System.out.println(request.getParameter("enterprise_id"));
            System.out.println(request.getParameter("acquirer_enterprise_id"));
            System.out.println(request.getParameter("amount"));
            System.out.println(request.getParameter("instituty_id"));
            System.out.println(request.getParameter("create_time"));
            System.out.println(request.getParameter("expiry_time"));
            System.out.println(request.getParameter("payment_interest_type"));
            System.out.println(request.getParameter("status"));
            System.out.println(request.getParameter("ticket_remark"));
            System.out.println("进入 addTicketopeninfo");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmms");
        String fmt = sdf.format(System.currentTimeMillis());
        TicketOpen ticketOpen = new TicketOpen();
        ticketOpen.setNo(request.getParameter("Z" + fmt));
        ticketOpen.setEnterPriseId(request.getParameter("enterprise_id"));
        ticketOpen.setAcquirerEnterPriseId(request.getParameter("acquirer_enterprise_id"));
        ticketOpen.setAmount(Double.parseDouble(request.getParameter("amount")));
        ticketOpen.setInstitutyId(Integer.parseInt(request.getParameter("instituty_id")));
        System.out.println(ticketOpen);
        try {
            String create_time = request.getParameter("create_time");
            String expiry_time = request.getParameter("expiry_time");
            if(expiry_time.equals("")||expiry_time==null){

            }
            ticketOpen.setCreateTime(simpleDateFormat.parse(create_time));
            ticketOpen.setExpiryTime(simpleDateFormat.parse(expiry_time));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String type = request.getParameter("payment_interest_type");
        String typestr = type.equals("a") ? "融资方付息" : "核心企业付息";
        ticketOpen.setPaymentInterestType(typestr);
        String status = request.getParameter("status");
        String s = status.equals("1") ? "成功" : (status.equals("2") ? "开单中" : (status.equals("3") ? "已撤销" : "复核未通过"));
        ticketOpen.setStatus(s);
        System.out.println(ticketOpen);
        ticketOpen.setUplinkAddress(request.getParameter("uplink_address"));
        ticketOpen.setTicket_remark(request.getParameter("ticket_remark"));
        boolean b = new TicketopenBizImpl().addTicketopen(ticketOpen);
        response.getWriter().println(new Gson().toJson(b));
        System.out.println(new Gson().toJson(b));
    }

    protected void addTicketopeninfoByUserEnterId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("users");
        TicketOpen ticketopenbyUserEnterId = new TicketopenBizImpl().getTicketopenbyUserEnterId(user);
        response.getWriter().println(new Gson().toJson(ticketopenbyUserEnterId));
    }

    protected void getTicketopenByTicketView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TicketView> ticketViews =new ArrayList<>();
        TicketView ticketView=new TicketView();
        ticketViews.add((TicketView) ticketView.selectAll());
        response.getWriter().println(new Gson().toJson(ticketViews));
    }

    protected void getTicketopenByTicketViewForconditions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlHelper sqlHelper = new SqlHelper();
        sqlHelper.setNo(request.getParameter("no"));
        sqlHelper.setEnterPriseId(request.getParameter("enterPriseId"));
        sqlHelper.setAcquirerEnterPriseId(request.getParameter("acquirerEnterPriseId"));
        sqlHelper.setCreateTime(request.getParameter("createtime"));
        sqlHelper.setAmountMin(request.getParameter("amountMin"));
        sqlHelper.setAmountMax(request.getParameter("amountMax"));
        String status = request.getParameter("status");
        String s = status.equals("0") ? "" : (status.equals("1") ? "'成功'" : (status.equals("2") ? "'开单中'" : ("'已撤销' or status='复核未通过'")));
        sqlHelper.setStatus(s);
        List<TicketView> ticketViewsByno = new TicketView().selectAllByConnditions(sqlHelper);
        if (ticketViewsByno == null) {
            System.out.println("List<TicketView> ticketViewsByno 是空的");
        }else{
        response.getWriter().println(new Gson().toJson(ticketViewsByno));}
    }

    protected void getTicketopenByTicketViewForconditions2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入getTicketopenByTicketViewForconditions");
        SqlHelper sqlHelper = new SqlHelper();
        sqlHelper.setNo(request.getParameter("no"));
        sqlHelper.setEnterPriseId(request.getParameter("enterPriseId"));
        System.out.println(request.getParameter("enterPriseId"));
        sqlHelper.setAcquirerEnterPriseId(request.getParameter("acquirerEnterPriseId"));
        sqlHelper.setCreateTime(request.getParameter("createtime"));
        sqlHelper.setAmountMin(request.getParameter("amountMin"));
        sqlHelper.setAmountMax(request.getParameter("amountMax"));

        System.out.println(sqlHelper);

        List<TicketView> ticketViewsByno = new TicketView().selectAllByConnditions(sqlHelper);
        if (ticketViewsByno == null) {
            System.out.println("List<TicketView> ticketViewsByno 是空的");
        }else{
        response.getWriter().println(new Gson().toJson(ticketViewsByno));
        }


    }

    protected void getTicketInfoView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getTicketInfoView");
        String no = request.getParameter("no");

        ViewUtility viewUtility = new ViewUtility().slectInfoView(no);
        HttpSession session = request.getSession();
        session.setAttribute("ticketInfoviewUitlity", viewUtility);
        response.sendRedirect("open-detail.jsp");
        System.out.println(viewUtility);
    }

    //分页
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        TicketBizImpl ticketBiz = new TicketBizImpl();
        PageHelper<TicketOpen> pageHelper = new PageHelper<>();
        pageHelper.setIndexPage(1);
        pageHelper.setTotalCount(ticketBiz.getAllnum());
        pageHelper.setPageSize(3);
        pageHelper.setPageList(ticketBiz.getBypage(pageHelper));
        pageHelper.getTotalPage();
        Gson gson = new Gson();
        resp.getWriter().println(gson.toJson(pageHelper));
    }


    protected void getAllEsuc(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Esuc esuc = new Esuc();
        List<Esuc> esucs = esuc.queryEsuc(esuc);
        response.getWriter().println(new Gson().toJson(esucs));

    }

}