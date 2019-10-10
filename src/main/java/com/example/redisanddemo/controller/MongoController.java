package com.example.redisanddemo.controller;

import com.example.redisanddemo.bean.Location;
import com.example.redisanddemo.bean.Person;
import com.example.redisanddemo.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

@Controller
public class MongoController {
    @Autowired
    PersonRepository personRepository;
    @RequestMapping("/save")
    @ResponseBody
    public Person save()
    {
        MongoTemplate mongoTemplate;
        Person p=new Person("wyf",32);
        Collection<Location> locations=new LinkedHashSet<>();
        Location location1=new Location("上海","2009");
        Location location2=new Location("合肥","2010");
        Location location3=new Location("广州","2011");
        Location location4=new Location("马鞍山","2012");
        locations.add(location1);
        locations.add(location2);
        locations.add(location3);
        locations.add(location4);
        p.setLocations(locations);
        return personRepository.save(p);
    }
    @RequestMapping("/q1")
    public Person q1(String name){
        return personRepository.findByName(name);
    }
    @RequestMapping("/q2")
    public List<Person> q2(Integer age){
        return personRepository.withQueryFindByage(age);
    }
}
