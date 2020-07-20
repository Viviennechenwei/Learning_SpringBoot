package com.learning.generics;

/**
 * 传入泛型实参：
 * 定义一个生产器实现接口，虽然我们只创建了一个泛型接口Generator<T>,但是我们可以为T传入无数个实参，形成无数种类型的Generator接口
 * 在实现类实现泛型接口时，如已经将泛型类型传入实参类型，则所有泛型的地方都要替换成传入的实参类型
 * 即Generator<T>和public T next();中的T都要替换成传入的String类型
 */
public class GeneratorChild1 implements Generator<String> {
    @Override
    public String next() {
        return null;
    }
}
