package com.xsq.api.String;

/*
 * 1.java程序中所有双引号字符串，都是String类型的对象
 * 2.字符串不可改变，他们的值在创建后不可改变
 * 3.双引号创建的字符串对象是在字符串常量池中存储（不存在就创建，存在就复用）；构造方法创建的字符串对象是在堆内存中存储
 *
 * */
public class testString {
    public static void main(String[] args) {
        String str = "abc123";
        int length = str.length();
        System.out.println(length);
//构造方法
        //public String():创建一个空白字符串对象，不包含任何内容
        String s1 = new String();
        System.out.println(s1);//打印String对象名时，不会出现内存地址而是其真实内容

        //public String(char[] chs):根据字符数组的内容来创建字符串对象
        char[] chs = {'a', 'b', 'c'};
        String s2 = new String(chs);//数组拼接为字符串
        System.out.println(s2);

        //public String(String original):根据传入的字符串内容，来创建字符串对象
        String s3 = new String("123");
        System.out.println(s3);

//成员方法
        String s4 = "abc";

        String s5 = "ABC";
        System.out.println(s4.equals(s5));
        System.out.println(s4.equalsIgnoreCase(s5));//不考虑大小写

        System.out.println(s4.charAt(1));//返回字符串指定索引值的值

        char[] chars = s4.toCharArray();//将字符串拆分为字符数组
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

        //截取字符串：1.String substring(int beginIndex)
        //          2.String substring(int beginIndex,int endIndex)(含头不含尾)
        String s6 = "itheima";
        String s7 = s6.substring(2);
        System.out.println(s7);
        String s8 = s6.substring(2, 4);
        System.out.println(s8);

        //字符串替换：String replace(CharSequence target,CharSequence replacement)返回新的字符串
        String s9 = "abcTMDghi";
        String result = s9.replace("TMD", "***");
        System.out.println(result);

        //切割字符串：String[] split(String regex):根据传入的字符串作为规则进行切割，将切割后的内容存入字符串数组中，并将字符串数组返回
        String s11 = "张三,22";
        String[] arr = s11.split(",");
        System.out.println(arr[0] + "|||" + arr[1]);

    }
}
