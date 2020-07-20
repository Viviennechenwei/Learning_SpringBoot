package com.learning.generics;

/**未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需要将泛型的声明也一起加到类中
 *即GeneratorChild<T>要声明<T>
 */
public class GeneratorChild<T> implements Generator<T>{

    @Override
    public T next() {
        return null;
    }
}