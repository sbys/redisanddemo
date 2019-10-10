package com.example.redisanddemo.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.client.ClientSession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

@Configuration
@EnableMongoRepositories
public class MongoConfig {
    @Bean
    public MongoClient client() throws UnknownHostException
    {
        MongoClient client= new MongoClient(new ServerAddress("39.106.225.165"));
        return client;
    }
    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception{
        String database=new MongoClientURI("mongodb://39.106.225.165:27017/mongodemo").getDatabase();
        return new SimpleMongoDbFactory(client(),database);
    }
    @Bean
    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory)
    {
        return new MongoTemplate(mongoDbFactory);
    }
}
