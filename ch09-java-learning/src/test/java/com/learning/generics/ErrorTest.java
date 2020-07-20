package com.learning.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ErrorTest {

    //声明一个泛型方法，该泛型方法中带一个T类型形参
    static <T> void fromCollectionToCollection(Collection<? extends T> from, Collection<T> to){
        for(T f:from){
            to.add(f);
        }
    }

    @Test
    public void test(){
        List<Object> to = new ArrayList<>();
        List<String> from = new ArrayList<>();
        fromCollectionToCollection(from, to);
        /**
         * fromCollectionToCollection (java.util.Collection<T>, java.util.Collection<T>)
         * in ErrorTest cannot be applied
         * to(java.util.List<java.lang.String>, java.util.List<java.lang.Object>)
         *  
         *  reason: Incompatible equality constraint: Object and String
         */
    }
}
