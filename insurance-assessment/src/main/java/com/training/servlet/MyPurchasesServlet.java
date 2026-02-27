package com.training.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.training.config.SpringConfig;
import com.training.service.PurchaseService;

//@WebServlet("/purchases") --already mapped in web.xml
public class MyPurchasesServlet extends HttpServlet {
    private PurchaseService purchaseService;

    @Override
    public void init() throws ServletException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        purchaseService = context.getBean(PurchaseService.class);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Object customerObj = ((HttpSession) request.getSession(false)).getAttribute("customer");
        if (customerObj == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        
        com.training.entity.Customer customer = (com.training.entity.Customer) customerObj;
        request.setAttribute("purchases", purchaseService.getCustomerPurchases(customer.getId()));
        request.getRequestDispatcher("my-purchases.jsp").forward(request, response);
    }
}
