package com.training.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.training.config.SpringConfig;
import com.training.service.PurchaseService;
import com.training.entity.Customer;
import com.training.entity.Policy;

public class PurchaseServlet extends HttpServlet {
    private PurchaseService purchaseService;

    @Override
    public void init() throws ServletException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        purchaseService = context.getBean(PurchaseService.class);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("customer") == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        
        Customer customer = (Customer) session.getAttribute("customer");
        int customerId = customer.getId(); 
        int policyId = Integer.parseInt(request.getParameter("policyId"));
        
        purchaseService.purchasePolicy(customerId, policyId);
        
        Policy policy = purchaseService.getPolicyById(policyId);
        request.setAttribute("policy", policy);
        request.setAttribute("message", "Purchase completed successfully!");
        request.getRequestDispatcher("purchase.jsp").forward(request, response);
    }

}


