package com.atc.domains.customerAccount;

import com.atc.domains.customerAccount.entity.CustomerAccount;

import java.util.List;

/**
 * Created by Viki.Feng on 01/02/2016.
 */
public interface ICustomerAccountDAO {
    /**
     * insertAccount
     * @param customerAccount
     * @return
     */
    int insertAccount(CustomerAccount customerAccount);

    /**
     * CustomerAccountList
     * @return
     */
    List<CustomerAccount> getAccounts();
}
