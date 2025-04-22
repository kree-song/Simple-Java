package com.xsq.languageBase.Features.genericity;

//泛型类
public class testGenericityClass {
    public static void main(String[] args) {
        Box<String> box1 = new Box<>();
        box1.setElement("张三");
        String element1 = box1.getElement();
        System.out.println(element1);

        Box<Integer> box2 = new Box<>();
        box2.setElement(20);
        Integer element2 = box2.getElement();
        System.out.println(element2);
    }
}
