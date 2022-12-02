package com.jr.servelet;

import com.jr.dao.impl.UserDaolmpl;
import com.jr.entry.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Userervlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
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
     * 使用sesson存储用户登录后返回的对象
     * */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDaolmpl ud=new UserDaolmpl();
        User u3=new User();
        boolean boo=true;
        if (boo){
            resp.getWriter().println("<h1>success</h1>");
        }else {
            resp.sendRedirect("index.jsp");
        }
    }
}
