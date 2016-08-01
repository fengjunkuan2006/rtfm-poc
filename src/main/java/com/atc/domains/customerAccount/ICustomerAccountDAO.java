package com.atc.domains.customerAccount;

import com.atc.domains.customerAccount.entity.CustomerAccount;

import java.util.List;

/**
 * Created by Viki.Feng on 01/02/2016.
 */
public interface ICustomerAccountDAO {
    int insertAccount(CustomerAccount customerAccount);

    List<CustomerAccount> getAccounts();
}
