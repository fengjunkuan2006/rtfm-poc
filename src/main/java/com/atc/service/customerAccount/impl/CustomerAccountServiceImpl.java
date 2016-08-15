package com.atc.service.customerAccount.impl;

import com.atc.domains.customerAccount.ICustomerAccountDAO;
import com.atc.domains.customerAccount.entity.CustomerAccount;
import com.atc.service.customerAccount.ICustomerAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Neil.Fang on 7/25/2016.
 */
@Service
public class CustomerAccountServiceImpl implements ICustomerAccountService {
    private final Logger logger = LoggerFactory.getLogger(CustomerAccountServiceImpl.class);

    @Autowired
    ICustomerAccountDAO customerAccountDAO;

    public int addAccount(CustomerAccount customerAccount) {
        int result = 0;
        try {
            result = customerAccountDAO.insertAccount(customerAccount);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return result;
    }

    public List<CustomerAccount> getAccounts(String org) {
        List<CustomerAccount> result = null;
        try {
            result = customerAccountDAO.getAccounts(org);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return result;
    }
}
