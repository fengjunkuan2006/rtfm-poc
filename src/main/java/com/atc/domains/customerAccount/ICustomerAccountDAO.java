package com.atc.domains.customerAccount;

import com.atc.domains.customerAccount.entity.CustomerAccount;

import java.util.List;

/**
 * Created by Vic.Feng on 01/02/2016.
 */
public interface ICustomerAccountDAO {
    /**
     * insertAccount
     * @param customerAccount
     * @return
     */
    int insertAccount(CustomerAccount customerAccount);

    /**
     * Get customer account list
     *
     * @param org
     * @return
     */
    List<CustomerAccount> getAccounts(String org);
}
