package com.springboot.controller;

import com.springboot.dao.AccountDao;
import com.springboot.entiry.Account;
import com.springboot.entiry.Dog;
import com.springboot.entiry.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTestDeepMock {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    AccountController controller;

    @Test
    public void testDeepMock() throws Exception {
        AccountDao accountDao = controller.getAccountDao();
        List<Account> allAccount = accountDao.findAllAccount();
        System.out.println(allAccount);
    }


    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    Person person;

    @Test
    public void testDeepMockDog() throws Exception {
        Dog dog = person.getDog();
        dog.getDogName();
    }


//    @Mock
//    Dog dog;
//
//    @TestService
//    public void testDeepMockDog() throws Exception {
//        Mockito.when(person.getDog()).thenReturn(dog);
//        Dog dog = person.getDog();
//
//        dog.getDogName();
//    }
}
