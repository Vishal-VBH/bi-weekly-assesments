package com.training.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.training.config.SpringConfig;
import com.training.service.CustomerService;

public class CustomerRegistrationServlet extends HttpServlet {
    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        customerService = ctx.getBean(CustomerService.class);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phoneStr = request.getParameter("phone");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        
  
        long phone = Long.parseLong(phoneStr);
        
        

        customerService.registerCustomer(name, email, phone, address, password);
        response.sendRedirect("register-success.jsp");
    }
}
