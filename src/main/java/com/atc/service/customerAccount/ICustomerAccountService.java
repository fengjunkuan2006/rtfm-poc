package com.atc.service.customerAccount;import com.atc.domains.customerAccount.entity.CustomerAccount;import java.util.List;/** * Created by Vic.Feng on 30/11/2015. */public interface ICustomerAccountService {    int addAccount(CustomerAccount customerAccount);    /**     * Get List<CustomerAccount>     *     * @return List<CustomerAccount>     */    List<CustomerAccount> getAccounts();}