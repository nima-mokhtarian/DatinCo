package com.datin.elms.controller.mangeEmployee;


import com.datin.elms.model.Category_element;
import com.datin.elms.model.Employee;
import com.datin.elms.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/editEmployeeForm")
public class EditEmployeeFormSrv extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id")) ;
        EmployeeService employeeService = new EmployeeService() ;
        Employee employee = employeeService.getEmployeeById(id) ;
        List<Category_element> roleList = employeeService.getRole() ;

        //System.out.println(employee.getName());
        req.setAttribute("roleList",roleList);
        req.setAttribute("employee",employee);
        req.getRequestDispatcher("editemployee.jsp").forward(req,resp);

    }
}
