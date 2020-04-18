package com.springboot.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IsAMethodTest {

    //被mock类一定要用@InjectMocks， 如果用@Mock就会有NullpointException，worker是空
//    @Mock
//    Foo foo;
//
//    @Mock
//    Parent parent;

    @Test
    public void isATest() {
        Foo foo = Mockito.mock(Foo.class);
        Mockito.when(foo.fun(Mockito.isA(Parent.class))).thenReturn(100);
        int cd1 = foo.fun(new Child1());
        int cd2 = foo.fun(new Child2());
        Assert.assertEquals(cd1, 100);
        Assert.assertEquals(cd2, 100);
    }


   static class Foo {
        int fun(Parent p) {
            return p.work();
        }
    }

    interface Parent {
        int work();
    }

    class Child1 implements Parent {

        @Override
        public int work() {
            throw new RuntimeException();
        }
    }

    class Child2 implements Parent {

        @Override
        public int work() {
            throw new RuntimeException();
        }
    }
}
