package com.javalearning;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

public class ParallelStreamTest {

    @Test
    public void streamTest(){
        Instant start = Instant.now();
        long reduce = LongStream.rangeClosed(0, 100000000000L)
                //.parallel()
                .reduce(0, Long::sum);
        System.out.println(reduce);

        Instant end = Instant.now();
        System.out.println(Duration.between(end,start).toMillis()); //43172 - 16401
    }
}
