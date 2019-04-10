package com.gcdd1993.spring.framework.base.dao;

import com.gcdd1993.spring.framework.base.domain.Account;

/**
 * @author gaochen
 * @date 2019/3/26
 */
public class AccountDao {
    public Account findOne() {
        Account account = new Account();
        account.setId(1);
        account.setName("xiaowang");
        return account;
    }
}
