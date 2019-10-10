package com.example.redisanddemo.dao;

import com.example.redisanddemo.bean.Person;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person,String> {
    Person findByName(String name);
    @Query("{'age':?0}")
    List<Person> withQueryFindByage(Integer age);
}
