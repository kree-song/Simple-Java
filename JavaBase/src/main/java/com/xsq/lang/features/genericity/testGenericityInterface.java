package com.xsq.lang.features.genericity;

interface Genericity<E> {
    public abstract void method(E e);
}

//泛型接口
public class testGenericityInterface {
    public static void main(String[] args) {
        GenericityImpl<String> genericity = new GenericityImpl<>();
        genericity.method("你好，泛型");

        GenericityImpl2 genericityImpl2 = new GenericityImpl2();
        genericityImpl2.method(18);

    }
}

//定义实现类时,定义和接口相同泛型,创建实现类对象时明确泛型的具体类型
class GenericityImpl<E> implements Genericity<E> {
    @Override
    public void method(E e) {
        System.out.println(e);
    }
}

//定义实现类时,直接明确泛型的具体类型
class GenericityImpl2 implements Genericity<Integer> {
    @Override
    public void method(Integer integer) {
        System.out.println(integer);
    }
}
