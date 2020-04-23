package com.javalearning;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class DateJava8Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyMMdd");

        Callable<LocalDate> task = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return LocalDate.parse("20200422", dtf);
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<LocalDate>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futureList.add(executor.submit(task));
        }
        for (Future<LocalDate> f : futureList) {
            System.out.println(f.get());
        }
        executor.shutdown();
    }


    //LocalDate、LocalTime、LocalDateTime
    @Test
    public void LocalDateTime_test() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 04, 22, 23, 01, 10);
        System.out.println(localDateTime1);

        LocalDateTime localDateTime2 = localDateTime.plusYears(1);
        System.out.println(localDateTime2);
        System.out.println(localDateTime2.getYear());
        System.out.println(localDateTime2.getMonth());
        System.out.println(localDateTime2.getMinute());
    }

    //Instant
    @Test
    public void Instant_test() {
        Instant instant = Instant.now();//默认时区UTC
        System.out.println(instant);//2020-04-22T15:11:40.751Z

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2020-04-22T23:11:40.751+08:00

        System.out.println(instant.toEpochMilli());//1587568317072
        System.out.println(Instant.ofEpochSecond(60));//1970-01-01T00:01:00Z
    }

    //Duration
    @Test
    public void Duration_test() throws InterruptedException {
        LocalTime localTime1 = LocalTime.now();
        Thread.sleep(1000);
        LocalTime localTime2 = LocalTime.now();
        System.out.println(Duration.between(localTime1, localTime2).toMillis());
    }

    //Period
    @Test
    public void Period_test() {
        LocalDate localDate1 = LocalDate.of(2020, 04, 01);
        LocalDate localDate2 = LocalDate.of(2020, 04, 22);

        Period period = Period.between(localDate1, localDate2);
        System.out.println(period);
        System.out.println(period.getDays());
    }

    //TemporalAdjuster和TemporalAdjusters
    @Test
    public void TemporalAdjuster_test() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);//2020-04-22T23:38:14.429
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(10);
        System.out.println(localDateTime1);//2020-04-10T23:38:14.429

        LocalDateTime with = localDateTime.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println(with);//2020-04-24T23:38:14.429

        //返回下一个工作日
        LocalDateTime nextWorkDate = localDateTime.with(d -> {
            LocalDateTime l = (LocalDateTime) d;
            DayOfWeek day = l.getDayOfWeek();
            if (day == DayOfWeek.FRIDAY) {
                return l.plusDays(3);
            } else if (day == DayOfWeek.SATURDAY) {
                return l.plusDays(2);
            } else {
                return l.plusDays(1);
            }

        });
        System.out.println(nextWorkDate); //2020-04-24T00:00:08.870
    }

    @Test
    public void DateTimeFormatter_test() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;//java8提供很多内置格式
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time.format(formatter)); //20200423

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");//自定义时间格式
        String str = formatter1.format(time); //LocalDateTime --> String
        System.out.println(str); //2020年04月23日

        LocalDateTime time1 = time.parse(str, formatter1); //String --> LocalDateTime
        System.out.println(time1);//2020-04-23T00:13:19
    }

    //ZonedDateTime, ZonedDate, ZonedTime
    @Test
    public void Zone_test() {
        LocalDateTime dateTime = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(dateTime); //2020-04-23T00:18:23.920

        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println); //所有的ZoneId

        LocalDateTime dateTime1 = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(dateTime); //2020-04-23T00:20:50.857

        ZonedDateTime dateTime2 = dateTime1.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(dateTime2); //2020-04-23T00:20:50.885+08:00[Asia/Shanghai]
    }
}
