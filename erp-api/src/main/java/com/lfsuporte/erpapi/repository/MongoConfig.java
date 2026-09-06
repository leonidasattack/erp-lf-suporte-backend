package com.lfsuporte.erpapi.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "lfsuporte";
    }

    @Override
    public MongoClient mongoClient() {
        // Forçando o Spring a usar o Atlas, sem choro nem fallback!
        return MongoClients.create(
                "mongodb+srv://admin:thr45h4tt4ck@cluster0.tkbfvyg.mongodb.net/lfsuporte?retryWrites=true&w=majority");
    }
}