package com.example.redisanddemo.dao;

import com.example.redisanddemo.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class RedisPersonDao {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Resource(description = "stringRedisTemplate")
    ValueOperations<String,String> valOpsStr;
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;
    @Resource(description = "redisTemplate")
    ValueOperations<Object,Object> valOps;
    public void stringRedisTemplateDemo(){
        valOpsStr.set("xx","yy");
    }
    public void save(Person person){
        valOps.set(person.getId(),person);
    }
    public String getString(){
        return valOpsStr.get("xx");
    }
    public Person getPerson(){
        return (Person)valOps.get("1");
    }
}
