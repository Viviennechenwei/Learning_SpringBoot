package com.springboot.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WildCardTest {

    @Mock
    WDService service;

    @Test
    public void tesMethodReturnint(){
        when(service.methodReturnint(anyInt(),anyString(),anyCollection(),isA(Serializable.class))).thenReturn(10);
        int res = service.methodReturnint(1,"qwe", Collections.emptyList(),"Mockito");
        Assert.assertEquals(10, res);
    }

    @Test
    public void testMethodReturnVoid(){
        doNothing().when(service).methodReturnVoid(anyInt(),anyString(),anyCollection(),isA(Serializable.class));
        service.methodReturnVoid(1,"qwe", Collections.emptyList(),"Mockito");
        //由于参数没有返回值，所以要判断方法的执行次数来验证
        verify(service,times(1)).methodReturnVoid(1, "qwe", Collections.emptyList(),"Mockito");
        //任意一个参数使用wildcard时， 其他也要使用wildcard。如果想指定特殊值，就要写在eq()内，否则拨错
        verify(service,times(1)).methodReturnVoid(anyInt(), eq("qwe"), anyCollection(), "Mockito");
    }
}

class WDService {

    public int methodReturnint(int i, String s, Collection c, Serializable b){
        throw new RuntimeException();
    }
    public void methodReturnVoid(int i, String s, Collection c, Serializable b){
        throw new RuntimeException();
    }
}
