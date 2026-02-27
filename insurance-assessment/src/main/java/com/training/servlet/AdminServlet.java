package com.training.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.training.config.SpringConfig;
import com.training.service.PolicyService;
import com.training.entity.Policy;

public class AdminServlet extends HttpServlet {
    private PolicyService policyService;

    @Override
    public void init() throws ServletException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        policyService = context.getBean(PolicyService.class);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("policies", policyService.getAllPolicies());
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if ("add".equals(action)) {
            String name = request.getParameter("name");
            double premium = Double.parseDouble(request.getParameter("premium"));
            int duration = Integer.parseInt(request.getParameter("duration"));
            String description = request.getParameter("description");
            
            Policy policy = new Policy();
            policy.setPolicyType(name);
            policy.setPremium(premium);
            policy.setDuration(duration);
            policy.setDescription(description);
            
            policyService.addPolicy(policy);
        } else if ("delete".equals(action)) {
            Long policyId = Long.parseLong(request.getParameter("policyId"));
            policyService.deletePolicy(policyId);
        }
        
        response.sendRedirect("admin");
    }
}
