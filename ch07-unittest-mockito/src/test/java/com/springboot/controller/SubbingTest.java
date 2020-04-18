package com.springboot.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class SubbingTest {

    @Mock
    private List<String> list;


    @Test
    public void how_to_use_subbing(){
        //return时thenReturn和doReturn功能一样
        Mockito.when(list.get(0)).thenReturn("first");
        Mockito.doReturn("second").when(list).get(1);

        Assert.assertEquals("first", list.get(0));
        Assert.assertEquals("second", list.get(1));

        //有返回值throw时用thenThrow
        Mockito.when(list.get(Mockito.anyInt())).thenThrow(new RuntimeException());
        try {
            list.get(0);
            fail();
        }catch (Exception e){
            Assert.assertThrows(RuntimeException.class,()->list.get(0));
        }
    }

    @Test
    public void how_to_subbing_return_void_method(){
        //对无返回值的方法Mock
        Mockito.doNothing().when(list).clear();
        list.clear();
        Mockito.verify(list,Mockito.times(1)).clear();
        //无返回值throw时用doThrow
        Mockito.doThrow(RuntimeException.class).when(list).clear();
        try {
            list.clear();
            fail();
        }catch (Exception e){
            Assert.assertThrows(RuntimeException.class,()->list.clear());
        }
    }


    @Test
    public void subbing_with_answer(){
        Mockito.when(list.get(Mockito.anyInt())).thenAnswer(new Answer() {
            public Integer answer(InvocationOnMock invocation) throws Throwable {
                return (Integer) invocation.getArguments()[0]*10;
            }
        });
        Assert.assertEquals(list.get(2),20);
        Assert.assertEquals(list.get(88),880);
    }

    @Test
    public void subbing_with_real_call(){
        TestService service = Mockito.mock(TestService.class);
        Mockito.when(service.m1()).thenReturn("MockM1");
        Assert.assertEquals("MockM1", service.m1());

        Mockito.when(service.m2()).thenCallRealMethod();
        Assert.assertEquals("RealM2", service.m2());


    }

}
