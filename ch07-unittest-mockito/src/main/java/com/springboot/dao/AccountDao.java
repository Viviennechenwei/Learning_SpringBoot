package com.springboot.dao;

import com.springboot.entiry.Account;

import java.util.List;

public class AccountDao {

    public Account findAccount(String userName, String password) throws Exception {
        throw new Exception("DB could not use now"); //模拟DB不可用
    }

    public List<Account> findAllAccount() throws Exception {
        throw new Exception("DB could not use now"); //模拟DB不可用
    }
}
