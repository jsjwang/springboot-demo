package com.mmy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListTest {
    @Autowired
    private Demo1 demo1;


    @Test
    public void test1(){
        demo1.setList2("nums","1");
        System.out.println(demo1.getList("nums"));
        System.out.println(demo1.getlistSize("nums"));
    }
}
