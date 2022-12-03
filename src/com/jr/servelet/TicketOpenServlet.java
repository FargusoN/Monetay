package com.jr.servelet;

import com.jr.entry.Ticketopen;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class TicketOpenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  //      super.doGet(req, resp);
        req.setCharacterEncoding("utf-8"); //设置请求信息的字符为utf-8
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    /**
     * 获取所有ticketopen开单表中的信息
     */
    protected void getAllTicketopeninfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8"); //设置请求信息的字符为utf-8
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

    }
/**
 * 获取所有符合条件的ticketopen开单表信息
 * 这里使用前台异步查询,提供了字符串拼接工具类
 * 可以直接在里边拼接所需要属性的字符串
 * */
    protected void getTicketopeninfoByconditions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8"); //设置请求信息的字符为utf-8
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

    }

    private void dailyincomenumber(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8"); //设置请求信息的字符为utf-8
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
    }

}
