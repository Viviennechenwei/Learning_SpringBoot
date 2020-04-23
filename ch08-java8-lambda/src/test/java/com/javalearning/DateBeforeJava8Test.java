package com.javalearning;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class DateBeforeJava8Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddd");
        Callable task = new Callable() {
            @Override
            public Object call() throws Exception {
                return sdf.parse("20200422");
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<Date>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(executor.submit(task));
        }

        for (Future f : results) {
            System.out.println(f.get());
        }
        executor.shutdown();
    }

    @Test
    public void old_dateformat_safethread_test() throws ExecutionException, InterruptedException {

        Callable<Date> task = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return DateBeforeJava8Test.convert("20200422");
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<Date>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
             results.add(executor.submit(task));
        }
        for (Future f:results){
            System.out.println(f.get());
        }
        executor.shutdown(); //一定要关executor，否则程序不会终止
    }

    public final static ThreadLocal<DateFormat> tl = new ThreadLocal<DateFormat>() {

        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd");
        }
    };

    public static Date convert(String source) throws ParseException {
        return tl.get().parse(source);
    }
}
