package com.springboot.controller;

import com.springboot.dao.AccountDao;
import com.springboot.entiry.Account;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTestAnnation {

    //@Mock的对象会自动注入该类中，比如AccountController用到AccountDao。 那么在Mock AccountDao的时候，AccountController里的AccountDao也会被设置
    @InjectMocks
    AccountController accountController;

    @Mock
    HttpServletRequest request;

    //@Mock的对象会返回一个没有set任何值的对象。就相当与new AccountDao()
    @Mock
    AccountDao accountDao;

    @Test
    public void login_success() throws Exception {
        Account account = new Account();
        //subbing，对request.getParameter()进行mock，当调用request.getParameter("userName")时，会被mock截取并返回"Vivienne"
        Mockito.when(request.getParameter("userName")).thenReturn("Vivienne");
        Mockito.when(request.getParameter("password")).thenReturn("123");
        //subbing，对accountDao.findAccount()进行mock，anyString()表示无论传入的参数是什么，都会被mock截取并返回account
        Mockito.when(accountDao.findAccount(anyString(), anyString())).thenReturn(account);
        //断言，判断结果，如果返回"/index"，则测试通过
        Assert.assertEquals("/index",accountController.login(request));
    }

    @Test
    public void login_fail() throws Exception {
        Account account = new Account();
        Mockito.when(request.getParameter("userName")).thenReturn("Vivienne");
        Mockito.when(request.getParameter("password")).thenReturn("123");
        Mockito.when(accountDao.findAccount(anyString(), anyString())).thenReturn(null);
        Assert.assertEquals("/login",accountController.login(request));
    }

    @Test
    public void login_exception() throws Exception {
        Account account = new Account();
        Mockito.when(request.getParameter("userName")).thenReturn("Vivienne");
        Mockito.when(request.getParameter("password")).thenReturn("123");
        Mockito.when(accountDao.findAccount(anyString(), anyString())).thenThrow(new Exception());
        Assert.assertEquals("/505",accountController.login(request));
    }
}