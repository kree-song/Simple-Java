package com.xsq.lang.features.properties;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/*
 * Properties和IO流结合的方法
 * void load(InputStream inStream)：从输入字节流读取属性列表(键和元素对)

 * void load(Reader reader)：从输入字符流读取属性列表(键和元素对)

 * void store(OutputStream out,String comments)：将此属性列表(键和元素对)写入此Properties表中，以适合于使用load(InputStream)方法的格式写入输出字节流

 * void store(Writer writer,String comments)：将此属性列表(键和元素对)写入此Properties表中，以适合于使用load(Reader)方法的格式写入输出字节流
 * */
public class testPropertiesIOMethod {
    public static void main(String[] args) throws IOException {
        testLoad();
        //testStore();
    }

    private static void testStore() throws IOException {
        Properties prop = new Properties();
        prop.put("zhangsan", "123");
        prop.put("lisi", "456");
        prop.put("wangwu", "789");
        FileWriter fw = new FileWriter("JavaBase\\src\\com\\xsq\\properties\\prop.properties");
        //comments:注释
        prop.store(fw, null);
        fw.close();
    }

    private static void testLoad() throws IOException {
        //读取
        Properties prop = new Properties();//配置文件不要有空格
        //单独写FileReader，方便关闭资源
        FileReader fr = new FileReader("JavaBase\\src\\com\\xsq\\properties\\prop.properties");
        //调用完了load方法之后，文件中的键值对数据已经在集合中了
        prop.load(fr);
        fr.close();
        System.out.println(prop);
    }
}
