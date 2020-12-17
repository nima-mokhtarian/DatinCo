package com.datin.elms.controller.email;


import com.datin.elms.service.EmailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteEmail")
public class DeleteEmailSrv extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =  Integer.parseInt(req.getParameter("id"));
        EmailService emailService = new EmailService() ;
        emailService.deleteById(id);
        req.getRequestDispatcher("email").forward(req,resp);
    }
}