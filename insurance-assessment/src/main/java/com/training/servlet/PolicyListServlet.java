package com.training.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.training.config.SpringConfig;
import com.training.service.PolicyService;

public class PolicyListServlet extends HttpServlet {
    private PolicyService policyService;

    @Override
    public void init() throws ServletException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        policyService = context.getBean(PolicyService.class);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("policies", policyService.getAllPolicies());
        request.getRequestDispatcher("policies.jsp").forward(request, response);
    }
}
