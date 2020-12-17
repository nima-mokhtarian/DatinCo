package com.datin.elms.controller.email;


import com.datin.elms.model.Category_element;
import com.datin.elms.model.Email;
import com.datin.elms.model.Employee;
import com.datin.elms.service.EmailService;
import com.mysql.cj.jdbc.Blob;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

@WebServlet("/sendEmail")
public class SendEmailSrv extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String subject = req.getParameter("subject");
        String content = req.getParameter("content");
        String receiverEmail = req.getParameter("receiver");
//        Part filePart = req.getPart("file");
//        String fileName = getSubmittedFileName(filePart);
//        InputStream fileContent = filePart.getInputStream();

        Category_element emailStatus = new Category_element();
        emailStatus.setId(8);

        Email email = new Email() ;
        email.setSubject(subject);
        email.setContent(content);
        email.setEmail_receiver(receiverEmail);
        email.setStatus(emailStatus);
        Employee employee = (Employee) req.getSession().getAttribute("employee");
        email.setEmail_sender(employee.getEmail());
        EmailService emailService = new EmailService() ;
        emailService.save(email);
        req.getRequestDispatcher("email.jsp").forward(req,resp);
    }

    private static String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;

    }

}

