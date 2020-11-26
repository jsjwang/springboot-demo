package com.mmy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SetTest {
    @Autowired
    private Demo1 demo1;

    @Test
    public void test1(){
        String[] values={"a","b","c"};
        demo1.setRdSet("set1",values);
        System.out.println(demo1.getRdSet("set1"));
        System.out.println(demo1.isRdSetValueExists("set1","c"));
    }
    //差集
    @Test
    public void test2(){
      /*  String[] values={"a","b","c","e"};
        String[] values2={"a","b","c","d"};
        demo1.setRdSet("num1",values);
        demo1.setRdSet("num2",values2);*/
        System.out.println(demo1.differRdSet("num1","num2"));
        System.out.println(demo1.differRdSet("num2","num1"));
        System.out.println(demo1.interRdSet("num1","num2"));
        System.out.println(demo1.unionRdSet("num1","num2"));
    }
}
