package com.mmy;

import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import javax.xml.transform.sax.SAXTransformerFactory;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class Demo1 {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public void setString(String key, String value) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);
    }

    public String getString(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void setExpire(String key, Long timeout) {
        redisTemplate.expire(key, Duration.ofMinutes(timeout));
    }

    public Long getExpirt(String key) {
        return redisTemplate.getExpire(key);
    }

    public boolean delKey(String key) {
        return redisTemplate.delete(key);
    }

    public void delKeys(String... keys) {
        redisTemplate.delete(Arrays.asList(keys));
    }

    public boolean isKeyExists(String key) {
        return redisTemplate.hasKey(key);
    }

    public Long keyIncrement(String key, Long incr) {
        return redisTemplate.opsForValue().increment(key, incr);
    }

    public Long keyIncrement(String key) {
        return this.keyIncrement(key, 1L);
    }

    public Long keyDecrement(String key, Long decr) {
        return redisTemplate.opsForValue().decrement(key, decr);
    }

    public Long keyDecrement(String key) {
        return this.keyDecrement(key, 1L);
    }

    //hash

    public void setHash(String key, String field, String value) {
        redisTemplate.boundHashOps(key).put(field, value);
        //redisTemplate.opsForHash().put(key,field,value);
    }

    public List<String> getHashValueList(String key) {
        BoundHashOperations<String, String, String> ops = redisTemplate.boundHashOps(key);
        return ops.values();
    }

    public void setHashMaps(String key, Map map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    public Object getHashValue(String key, String field) {
        return redisTemplate.boundHashOps(key).get(field);
    }
    //提取所有的小keys

    public Set<Object> getHashFields(String key) {
        return redisTemplate.boundHashOps(key).keys();
    }

    //获取键值对集合
    public Map<Object, Object> getHashKeyValue(String key) {
        return redisTemplate.boundHashOps(key).entries();
    }

    public boolean isHashKeyExists(String key, String field) {
        return redisTemplate.boundHashOps(key).hasKey(field);
    }

    public Long hashIncrement(String key, String field, Long incr) {
        byte[] fieldBytes = field.getBytes();
        return redisTemplate.execute((connection) -> {
            return connection.incrBy(fieldBytes, incr);
        }, true);
    }

    public Long hashIncrement2(String key, String field, Long incr) {
        return redisTemplate.boundHashOps(key).increment(field, incr);
    }

    public Long hashIncrement2(String key, String field) {
        return this.hashIncrement2(key, field, 1L);
    }

    public Long delHash(String key, String... field) {
        return redisTemplate.boundHashOps(key).delete(field);
    }


    //list列表系列

    public List<String> getList(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }
    public List<String> getList(String key){
        return this.getList(key,0,-1);
    }
    public Long setList2(String key,String value) {
        return redisTemplate.boundListOps(key).leftPush(value);
    }
    public Long getlistSize(String key){
        return redisTemplate.boundListOps(key).size();
    }

    //set集合
    public void setRdSet(String key,String...values){
        redisTemplate.opsForSet().add(key,values);
    }
    public Set getRdSet(String key){
        Set<String> members = redisTemplate.boundSetOps(key).members();
        return members;
    }
    public boolean isRdSetValueExists(String key,String value){
        return redisTemplate.boundSetOps(key).isMember(value);
    }
    //差集运算
    public Set differRdSet(String key1,String key2){
        Set<String> diff = redisTemplate.boundSetOps(key1).diff(key2);
        return diff;
    }
    //交集
    public Set interRdSet(String key1,String key2){
        return redisTemplate.boundSetOps(key1).intersect(key2);
    }
    public Set unionRdSet(String key1,String key2){
        return redisTemplate.boundSetOps(key1).union(key2);
    }
    public Long getSetCount(String key){
        return redisTemplate.boundSetOps(key).size();
    }

    //有序集合

    public void setSortList(String key,String field,double d){
        redisTemplate.boundZSetOps(key).add(field,d);

    }
    public void setSortLists(String key, Set<ZSetOperations.TypedTuple<String>> set){
        redisTemplate.boundZSetOps(key).add(set);
    }
    public Double getSortList(String key,String field){
        return redisTemplate.boundZSetOps(key).score(field);
    }
    //按照排名打印
    public Set getSortListBySccore(String key, Long start, Long end){
        return redisTemplate.boundZSetOps(key).range(start,end);
    }
    public Set getSortValuesByScore(String key){
        return redisTemplate.boundZSetOps(key).range(0L,-1L);
    }
    //获取指定分数范围内的成员的个数
    public Long getSortValueByExample(String key,double d1,double d2){
        return redisTemplate.boundZSetOps(key).count(d1,d2);
    }
    //事务
    public void startTransaction(){
        redisTemplate.multi();
    }
    public void execTransaction(){
        redisTemplate.exec();
    }
}
