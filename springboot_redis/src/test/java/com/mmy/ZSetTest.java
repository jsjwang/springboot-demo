package com.mmy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZSetTest {

    @Autowired
    private Demo1 demo1;

    @Test
    public void test1(){
        demo1.setSortList("score","tom",89);
        demo1.setSortList("score","jack",90);
        Double score = demo1.getSortList("score", "tom");
        System.out.println(score);
    }

    @Test
    public void test2(){
       /* DefaultTypedTuple<String> dtt1= new DefaultTypedTuple<String>("tom",123D);
        DefaultTypedTuple<String> dtt2 = new DefaultTypedTuple<>("jack",12D);
        demo1.setSortLists("scores",new HashSet<>(Arrays.asList(dtt1,dtt2)));*/
        Set scores = demo1.getSortListBySccore("scores", 0L, 1L);
        System.out.println(scores);
    }
}
