package com.javalearning;

import org.junit.Test;

import java.util.function.Function;

public class ConstructorReferenceTest {

    @Test
    public void constructor_referent_test(){

        Function<String,Account> supplier = (x)->new Account(x);
        Account account = supplier.apply("vivi");
        System.out.println(account);

        Function<String,Account> supplier1 = Account::new;
        Account account1 = supplier1.apply("Vivi");
        System.out.println(account1);
    }
}
