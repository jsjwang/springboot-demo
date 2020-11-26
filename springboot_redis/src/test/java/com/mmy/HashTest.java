package com.mmy;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HashTest {

    @Autowired
    private Demo1 demo1;
    private static final Logger logger = LoggerFactory.getLogger(HashTest.class);

    //hash表的增加与获取
    @Test
   public void test1(){
        demo1.setHash("car","color","黑色");
        demo1.setHash("car","name","宝马");
        demo1.setHash("car","price","100万");
        List<String> car = demo1.getHashValueList("car");
        System.out.println(car);
        Object obj =demo1.getHashValue("car","color");
        System.out.println(obj);

    }
    //测试增加map
    @Test
    public void test2(){
        /*Map<String,String> map = new HashMap<>();
        UserInfo userInfo = new UserInfo("jack","123");
        UserInfo userInfo2 = new UserInfo("jack22","123");
        map.put("1", JSON.toJSONString(userInfo));
        map.put("2", JSON.toJSONString(userInfo2));
        demo1.setHashMaps("user",map);*/
        List<String> user = demo1.getHashValueList("user");
        System.out.println(user);
        Object hashValue = demo1.getHashValue("user", "1");
        System.out.println(hashValue);
        System.out.println(demo1.getHashFields("user"));
        System.out.println(demo1.getHashKeyValue("user"));
        System.out.println(demo1.isHashKeyExists("user","1"));
    }
    //测试键的自增
    @Test
    public void test3(){
        //demo1.setHash("ariticle","ID","1");
        System.out.println(demo1.hashIncrement("ariticle","ID",1L));
       // System.out.println(demo1.hashIncrement2("ariticle","ID",2L));
        System.out.println(demo1.delHash("ariticle","ID"));
    }
    //hash小实例
    @Test
    public void test4(){
        Long articleId = demo1.keyIncrement("articleId");
        String key="article:"+articleId;
        demo1.setHash(key,"title","人物");
        demo1.setHash(key,"author","小白");
        demo1.setHash(key,"date",new Date().toString());
        System.out.println(demo1.getHashValueList(key));
    }
}
