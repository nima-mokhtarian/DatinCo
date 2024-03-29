package com.datin.elms.controller.mangeEmployee;

import com.datin.elms.model.Employee;
import com.datin.elms.repository.CategoryDao;
import com.datin.elms.repository.EmployeeDao;
import com.datin.elms.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/addEmployeeToDb")
public class AddEmpToDbSrv extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String family = req.getParameter("family");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phoneNumber = req.getParameter("phonenumber");
        int roleId = Integer.parseInt(req.getParameter("roleName")) ;
        Employee manager = (Employee) req.getSession().getAttribute("employee") ;
        EmployeeService employeeService = new EmployeeService() ;

        employeeService.AddEmployee(name,family,username,password,email,phoneNumber,roleId,manager);

        resp.sendRedirect("employees");

    }
}
