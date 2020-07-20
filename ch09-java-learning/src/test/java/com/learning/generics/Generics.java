package com.learning.generics;

//在实例化泛型类时，必须指定T的具体类型
public class Generics<T> {

    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public Generics(T key) {
        this.key = key;
    }

    //这只是类中的一个普通成员方法，只不过它的返回值是在声明泛型类已经声明过的泛型。
    //所以在这个方法中才可以继续使用T这个泛型
    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }


    /**这才是一个真正的泛型方法
     * @param obj
     * @param <T> <T>必不可少，表明这是一个泛型方法，并且声明的一个泛型T
     *            泛型的个数也可以为任意多个public <T， K> T test(Generics<T> obj){}
     * @return
     */

    public <T> T test(Generics<T> obj){
        System.out.println("obj is" + obj);
        T t = obj.getKey();
        return t;
    }

    /**
     *编译报错，因为我们只声明了T, 并未声明E, 正确的写法public <E> E test1(Generics<E> obj){
     */
//    public <T> T test1(Generics<E> obj){
//        System.out.println("obj is" + obj);
//        T t = obj.getKey();
//        return t;
//    }
}

