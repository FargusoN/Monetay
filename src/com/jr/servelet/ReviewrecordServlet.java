package com.jr.servelet;



import com.jr.biz.impl.ReviewrecordBizImpl;
import com.jr.biz.impl.TicketopenBizImpl;
import com.jr.entry.Reviewrecord;
import com.jr.entry.Ticketopen;
import com.jr.until.PageHelper;
import com.jr.until.SqlHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ms")
public class ReviewrecordServlet extends HttpServlet {
    Reviewrecord reviewrecord=new Reviewrecord();
    ReviewrecordBizImpl reviewrecordBiz=new ReviewrecordBizImpl();
    TicketopenBizImpl ticketopenBiz=new TicketopenBizImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        page(request,response);

    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }


}
