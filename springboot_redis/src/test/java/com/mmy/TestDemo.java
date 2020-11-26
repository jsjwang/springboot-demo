package com.mmy;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemo {
    private static Logger logger = LoggerFactory.getLogger(TestDemo.class);

    @Resource
    private Demo1 demo1;

    //字符串的普通应用
    @Test
    public void test(){
        //demo1.setString("key1","hello,你好!");
        logger.info("打招呼:{}",demo1.getString("key1"));
        UserInfo userInfo = new UserInfo("小明","123345");
        demo1.setString("user1", JSON.toJSONString(userInfo));
        logger.info("用户:{}",demo1.getString("user1"));
    }
    //给可以设置过期时间
    @Test
    public void test2(){
        logger.info("程序开始");
        demo1.setString("key2","1");
        demo1.setExpire("key2",1L);
        logger.info(demo1.getString("key2"));
        logger.info("key2的过期时间为:{}",demo1.getExpirt("key2"));
    }
    //删除key
    @Test
    public void test3(){
        logger.info("程序开始");
        demo1.setString("key1","测试....");
        logger.info(demo1.getString("key1"));
        boolean res = demo1.delKey("key1");
        System.out.println(res);
        logger.info(demo1.getString("key1"));
        demo1.setString("key2","测试...222");
        demo1.setString("key3","测试...222");
        demo1.setString("key4","测试...222");
        demo1.setString("key5","测试...222");
    }
    //批量删除key
    @Test
    public void test5(){
        String[] keys={"key2","key3","key4","key5"};
        demo1.delKeys(keys);
        logger.info("success");
    }
    //判断某个可以是否存在
    @Test
    public void test6(){
        logger.info("key33:{}",demo1.isKeyExists("key33"));
        logger.info("list:{}",demo1.isKeyExists("list"));
    }
    //对某个数值可以进行增减
    @Test
    public void test7(){
        demo1.setString("key1","1");
        logger.info("res:{}",demo1.keyIncrement("key1",2L));
        logger.info("res:{}",demo1.keyDecrement("key1"));
        logger.info("res:{}",demo1.keyDecrement("key1",1L));
        logger.info("res:{}",demo1.keyDecrement("key1"));
        logger.info("finalRes:{}",demo1.getString("key1"));
    }

    //字符串的简单应用
    @Test
    public void test8(){
        Long userID=demo1.keyIncrement("user:userID");
        UserInfo user = new UserInfo("tom","123");
        String key = "user:"+userID;
        demo1.setString(key,JSON.toJSONString(user));
        String gkey="user:"+1;
        String str = demo1.getString(gkey);
        UserInfo userInfo = JSON.parseObject(str, UserInfo.class);
        System.out.println(userInfo);
    }


}
