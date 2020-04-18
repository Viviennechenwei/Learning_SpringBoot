package demo;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.mockito.internal.util.StringUtil;
import org.springframework.test.context.event.annotation.AfterTestClass;

import static org.junit.jupiter.api.Assertions.*;

class StringUtil2Test {
    @Test
    void isBlank_null() {
        assertTrue(StringUtil2.isBlank(null));
    }

    @Test
    void isBlank() {
        System.out.println();
        assertTrue(StringUtil2.isBlank(""), "Should be true when input is empty");
    }
    @Test
    void isBlank_tab() {
        assertTrue(StringUtil2.isBlank(new String(new char[]{(char)9})));
    }

    @Test
    void isBlank_one_blank_character() {
        assertTrue(StringUtil2.isBlank(" "));
    }

    @Test
    void isBlank_multiple_blank_characters() {
        assertTrue(StringUtil2.isBlank("  "));
    }

    @Test
    void isBlank_tab_characters() {
        assertTrue(StringUtil2.isBlank("    "));
    }

    @Test
    void isBlank_blank_at_beginning_followed_by_letter() {
        assertFalse(StringUtil2.isBlank(" a"));
    }

    @Test
    void isBlank_blank_at_end_start_with_letter() {
        assertFalse(StringUtil2.isBlank("a "));
    }

    @Test
    void isBlank_letter_around_by_blank() {
        assertFalse(StringUtil2.isBlank(" a "));
    }


    @Test
    void performance(){
//        StringBuilder stringBuilder = new StringBuilder();
//        for(int i = 0; i<1000*100000; i ++){
//            stringBuilder.append("a");
//        }
//        String s = stringBuilder.toString();
        long start = System.currentTimeMillis();
        int count = 100 * 100000;
        for(int i = 0; i< count; i ++){
            StringUtil2.isBlank(a);
        }
        long end = System.currentTimeMillis();
        System.out.println((end-start));//17
    }


    @Test
    void performance2(){
        long start = System.currentTimeMillis();
        int count = 100 * 100000;
        for(int i = 0; i< count; i ++){
            StringUtil2.isBlank2(a);
        }
        long end = System.currentTimeMillis();
        System.out.println((end-start));//17
    }


    static final String a = "The self-isolation necessary to stop the spread of the coronavirus pandemic has been challenging, especially for those who live alone. While those waiting things out with family or roommates can still arrange group activities, single person households are bound to be a little quieter. If you live on your own, there may be a silver lining to your unprecedented new lifestyle. There are a ton of things you can do by yourself while you're social distancing that may even help you emerge from this solo period smarter, happier, and in better shape than you were before. Keep reading for our self-isolation to-do list, which features several free or low-cost activities that you can pick up right now.";

}