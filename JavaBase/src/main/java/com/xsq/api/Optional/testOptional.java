package com.xsq.api.Optional;

import java.util.Optional;

/**
 * static <T> Optional<T> of(T value)：为非null的值创建一个Optional，若传入参数为null，则抛出NullPointerException
 * static <T> Optional<T> ofNullable(T value)：为指定的值创建一个Optional，若指定的值为null，则返回一个空的Optional
 *
 * boolean isPresent()：若值存在返回true，否则返回false
 * T get()：若Optional有值则将其返回，否则抛出NoSuchElementException
 * T orElse(T other)：若有值则将其返回，否则返回指定的其它值
 * T orElseGet(Supplier<? extends T> other)：若有值则将其返回，orElse方法将传入的字符串作为默认值，orElseGet方法可以接受Supplier接口的实现用来生成默认值
 *
 * void ifPresent(Consumer<? super T> consumer)：若Optional实例有值则为其调用consumer，否则不做处理
 * <T> Optional<T> filter(Predicate<? super T> predicate)：若有值并且满足断言条件返回包含该值的Optional，否则返回空Optional
 * <U> Optional<U> map(Function<? super T,?  extends U> mapper)：若返回值不为null，则创建包含mapping返回值的Optional作为map方法返回值，否则返回空Optional
 * <U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper)：flatMap与map方法类似，区别在于flatMap中的mapper返回值必须是Optional
 */
public class testOptional {
    public static void main(String[] args) {
        //创建Optional对象
        Optional<String> tony = Optional.of("Tony");//若传入参数为null，则抛出NullPointerException
        Optional<String> kitty = Optional.ofNullable("Kitty");//若传入参数为null，则返回一个空的Optional
        Optional<String> kitty2 = Optional.ofNullable(null);

        System.out.println(kitty2.isPresent());//false
        System.out.println(tony.get());//无值抛出NoSuchElementException
        System.out.println(kitty2.orElse("Kitty"));//无值返回指定的其它值
        System.out.println(kitty2.orElseGet(() -> "KittyKitty1".substring(0,10)));//无值接受Supplier接口的实现用来生成默认值
        System.out.println("------------------");

        kitty.ifPresent(o -> System.out.println(o + "Kitty"));//若Optional实例有值则为其调用consumer，否则不做处理
        Optional<String> s = kitty.filter(o -> o.length() > 4);
        System.out.println(s.orElse("长度小于等于4"));//Kitty
        Optional<String> s1 = kitty.map(o -> o + "Kitty");
        System.out.println(s1.orElse("修改失败"));//KittyKitty
        Optional<String> s2 = kitty.flatMap(o -> Optional.ofNullable(o + "Kitty"));
        System.out.println(s2.orElse("修改失败"));//KittyKitty

    }
}
