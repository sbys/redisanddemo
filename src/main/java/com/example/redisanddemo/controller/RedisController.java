package com.example.redisanddemo.controller;

import com.example.redisanddemo.bean.Person;
import com.example.redisanddemo.dao.RedisPersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    RedisPersonDao personDao;
    @RequestMapping("/set") //1
    public void set(){
        Person person = new Person("1","wyf", 32);
        personDao.save(person);
        personDao.stringRedisTemplateDemo();
    }
    @RequestMapping("/getStr") //2
    public String getStr(){
        return personDao.getString();
    }
    @RequestMapping("/getPerson") //3
    public Person getPerson(){
        return personDao.getPerson();
    }

}
