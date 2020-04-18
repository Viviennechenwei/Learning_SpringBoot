package com.springboot.controller;

import com.springboot.dao.AccountDao;
import com.springboot.entiry.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

public class AccountController {

    @Autowired
    AccountDao accountDao;

    @RequestMapping
    public String login(HttpServletRequest request){
        try {
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            Account account = accountDao.findAccount(userName, password);
            if(account==null){
                return "/login";
            }else{
                return "/index";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "/505";
        }
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }
}
