package com.atc.service.customerAccount.impl;

import com.atc.domains.customerAccount.ICustomerAccountDAO;
import com.atc.domains.customerAccount.entity.CustomerAccount;
import com.atc.service.customerAccount.ICustomerAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Neil.Fang on 7/25/2016.
 */
@Service
public class CustomerAccountServiceImpl implements ICustomerAccountService {
    @Autowired
    ICustomerAccountDAO customerAccountDAO;

    public int addAccount(CustomerAccount customerAccount) {
        return customerAccountDAO.insertAccount(customerAccount);
    }

    public List<CustomerAccount> getAccounts(String org) {
        return customerAccountDAO.getAccounts(org);
    }
}
