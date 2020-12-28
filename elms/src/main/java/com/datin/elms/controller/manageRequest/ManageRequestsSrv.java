package com.datin.elms.controller.manageRequest;


import com.datin.elms.model.Employee;
import com.datin.elms.model.LeaveRequest;
import com.datin.elms.repository.RequestDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/manageRequests")
public class ManageRequestsSrv extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Employee employee = (Employee) req.getSession().getAttribute("employee");
        RequestDao requestDao = new RequestDao();
        List<LeaveRequest> leaveRequests = requestDao.getRequestsByManager(employee);
        req.setAttribute("leaveRequests", leaveRequests);
        req.getRequestDispatcher("manageRequests.jsp").forward(req, resp);

    }
}
