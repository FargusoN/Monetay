package com.jr.servelet;

import com.jr.biz.IUserBiz;
import com.jr.biz.impl.UserBizImpl;
import com.jr.entry.User;
import com.mysql.cj.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Userervlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       login(req,resp);
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
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        UserBizImpl userBiz=new UserBizImpl();
        User user=new User();
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        user.setAccount(account);
        user.setPassword(password);
        if (userBiz.login(user)!=null){
            request.getRequestDispatcher("ticket-open.jsp").forward(request,response);
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
        }else{
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }
}
