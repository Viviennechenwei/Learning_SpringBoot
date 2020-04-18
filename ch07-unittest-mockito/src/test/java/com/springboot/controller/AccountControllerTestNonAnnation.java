package com.springboot.controller;

import com.springboot.dao.AccountDao;
import com.springboot.entiry.Account;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import java.lang.reflect.Field;

import static org.mockito.ArgumentMatchers.anyString;


@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTestNonAnnation {

    //不用@Mock
    private AccountController accountController;

    private HttpServletRequest request;

    private AccountDao accountDao;

    @Before
    public void setup() throws NoSuchFieldException, IllegalAccessException {
        this.request = Mockito.mock(HttpServletRequest.class);
        this.accountDao = Mockito.mock(AccountDao.class);
        this.accountController = new AccountController();
        Field ad = accountController.getClass().getDeclaredField("accountDao");
        ad.setAccessible(true);
        ad.set(accountController, accountDao);
    }

    @Test
    public void login_success() throws Exception {

        Account account = new Account();
        Mockito.when(request.getParameter("userName")).thenReturn("Vivienne");
        Mockito.when(request.getParameter("password")).thenReturn("123");
        Mockito.when(accountDao.findAccount(anyString(), anyString())).thenReturn(account);
        Assert.assertEquals("/index", accountController.login(request));
    }

    @Test
    public void login_fail() throws Exception {
        Account account = new Account();
        Mockito.when(request.getParameter("userName")).thenReturn("Vivienne");
        Mockito.when(request.getParameter("password")).thenReturn("123");
        Mockito.when(accountDao.findAccount(anyString(), anyString())).thenReturn(null);
        Assert.assertEquals("/login", accountController.login(request));
    }

    @Test
    public void login_exception() throws Exception {
        Account account = new Account();
        Mockito.when(request.getParameter("userName")).thenReturn("Vivienne");
        Mockito.when(request.getParameter("password")).thenReturn("123");
        Mockito.when(accountDao.findAccount(anyString(), anyString())).thenThrow(Exception.class);
        Assert.assertEquals("/505", accountController.login(request));
    }
}