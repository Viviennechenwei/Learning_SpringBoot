package com.javalearning;

//专门来修饰函数式接口，要求接口中的抽象方法只有一个。这个注解一般会和lambda表达式一起使用
@FunctionalInterface
public interface NoReturnNoPara {

    void noReturnNoParaMethod();
}
