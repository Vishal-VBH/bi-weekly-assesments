package com.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.training.dao.PolicyDAO;
import com.training.entity.Policy;
import java.util.List;

@Service
public class PolicyService {

    @Autowired
    private PolicyDAO policyDAO;

    public List<Policy> getAllPolicies() {
        System.out.println("PolicyService: Fetching all policies");
        return policyDAO.findAllPolicies();
    }

    public void addPolicy(Policy policy) {
        System.out.println("PolicyService: Adding policy: " + policy.getPolicyType());
        policyDAO.savePolicy(policy);
    }

    public void deletePolicy(Long policyId) {
        System.out.println("PolicyService: Deleting policy ID: " + policyId);
        policyDAO.deletePolicy(policyId);
    }
}
