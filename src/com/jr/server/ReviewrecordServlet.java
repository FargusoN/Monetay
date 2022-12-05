package com.jr.server;

import com.jr.biz.impl.ReviewrecordBizImpl;
import com.jr.entry.Reviewrecord;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class ReviewrecordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doPost(req, resp);
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");


        int id=Integer.parseInt(request.getParameter("id"));
        int ticket_open_id=Integer.parseInt(request.getParameter("ticket_open_id"));
        int creator_id=Integer.parseInt(request.getParameter("creator_id"));
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String review_status=request.getParameter("review_status");
        String remark=request.getParameter("remark");
        Reviewrecord reviewrecord = new Reviewrecord();
        reviewrecord.setId(id);
        reviewrecord.setTicketOpenId(ticket_open_id);
        reviewrecord.setCreatorId(creator_id);
        try {
            reviewrecord.setCreateTime(simpleDateFormat.parse(request.getParameter("create_time")));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        reviewrecord.setReviewStatus(review_status);
        reviewrecord.setRemark(remark);
        ReviewrecordBizImpl reviewrecordBiz = new ReviewrecordBizImpl();
        int i = reviewrecordBiz.addReviewrecord(reviewrecord);
        if (i==0){
            System.out.println("复核失败");
        }else{
            System.out.println("复核/添加成功");
        }
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    protected void insertToticketopenAndreview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
