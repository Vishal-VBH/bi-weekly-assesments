package com.training.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.training.config.SpringConfig;
import com.training.service.CustomerService;
import com.training.entity.Customer;

public class LoginServlet extends HttpServlet {
    private static final String ADMIN_EMAIL = "admin@insurance.com";
    private static final String ADMIN_PASS = "Admin@123";
    
    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        customerService = context.getBean(CustomerService.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();
        String userType = request.getParameter("userType"); 

        if ("admin@insurance.com".equals(email) && "Admin@123".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("isAdmin", true);
            session.setAttribute("adminEmail", email);
            response.sendRedirect("admin.jsp");
            return;
        }

        // Customer login
        Customer customer = customerService.findByEmailAndPassword(email, password);
        if (customer != null) {
            HttpSession session = request.getSession();
            session.setAttribute("customer", customer);
            response.sendRedirect("home.jsp");
        } else {
            request.setAttribute("errorMessage", "Invalid credentials");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}
