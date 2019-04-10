package com.gcdd1993.spring.framework.base.service;

import com.gcdd1993.spring.framework.base.dao.AccountDao;
import com.gcdd1993.spring.framework.base.domain.Account;
import lombok.Data;

/**
 * @author gaochen
 * @date 2019/3/26
 */
@Data
public class AccountService {
    private AccountDao accountDao;

    public Account findOne() {
        return accountDao.findOne();
    }
}
