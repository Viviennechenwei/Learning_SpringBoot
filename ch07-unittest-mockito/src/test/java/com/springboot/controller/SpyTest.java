package com.springboot.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class SpyTest {

    @Spy
    List<String> list = new ArrayList<>();

    @Test
    public void spyTest(){
        list.add("spy1");
        list.add("spy2");

        Assert.assertEquals("spy1",list.get(0));
        Assert.assertEquals("spy2",list.get(1));

        Mockito.when(list.isEmpty()).thenReturn(true);
        Mockito.doThrow(RuntimeException.class).when(list).clear();

        Assert.assertEquals("spy1",list.get(0)); //调用真实的方法
        Assert.assertEquals("spy2",list.get(1));//调用真实的方法
        Assert.assertTrue(list.isEmpty()); //spy对象的list.isEmpty()被mock了，就返回mock的值
        Assert.assertThrows(RuntimeException.class, ()->list.clear());//spy对象的list.isEmpty()被mock了，就返回mock的值


    }
}
