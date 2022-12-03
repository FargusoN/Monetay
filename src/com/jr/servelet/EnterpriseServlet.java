package com.jr.servelet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import com.jr.biz.impl.EnterpriseBizImpl;
import com.jr.entry.Enterprise;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class EnterpriseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        getEnterpriseInfo(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
/**
 *通过用户传入进来的企业ID获取企业信息，在填入
 * */
    protected void getEnterpriseInfoByEnterpriseID(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
/**
 * 获取企业的全部信息列表
 * 将列表内企业名称展示在前端下拉框中
 *
 * */
    protected void getAllEnterprise(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    protected void getEnterpriseInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        EnterpriseBizImpl epl=new EnterpriseBizImpl();
        Enterprise Ep=new Enterprise();
        int id= Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        String socialuniformcode=req.getParameter("socialuniformcode");
        String email=req.getParameter("email");
        String phone=req.getParameter("phone");
        String address=req.getParameter("address");
        String scale=req.getParameter("scale");
        String fax=req.getParameter("fax");
        Ep.setId(id);
        Ep.setName(name);
        Ep.setSocialUniformCcode(socialuniformcode);
        Ep.setEmail(email);
        Ep.setPhone(phone);
        Ep.setAddress(address);
        Ep.setScale(scale);
        Ep.setFax(fax);
        if (epl.getEnterpriseInfo(id)!=null){
            req.getRequestDispatcher("ticket-open.jsp").forward(req,resp);
            HttpSession session=req.getSession();
            session.setAttribute("socialuniformcode",socialuniformcode);
            session.setAttribute("name",name);
        }

    }
}
