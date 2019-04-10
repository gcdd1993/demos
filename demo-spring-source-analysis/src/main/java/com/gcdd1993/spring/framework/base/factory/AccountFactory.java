package com.gcdd1993.spring.framework.base.factory;

import com.gcdd1993.spring.framework.base.domain.Account;

/**
 * @author gaochen
 * @date 2019/3/26
 */
public class AccountFactory {
    private static Account account = new Account();

    static {
        account.setId(1);
        account.setName("xiaowang");
    }

    public Account createAccountInstance() {
        return account;
    }
}
