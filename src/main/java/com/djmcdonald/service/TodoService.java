package com.djmcdonald.service;

import com.djmcdonald.config.TodoConfiguration;
import com.djmcdonald.repositories.TodosRepository;
import com.djmcdonald.repositories.TodosRepositoryImpl;
import com.djmcdonald.resources.TodoResource;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class TodoService extends Service<TodoConfiguration> {
    public static void main(String[] args) throws Exception {
        new TodoService().run(args);
    }

    @Override
    public void initialize(Bootstrap<TodoConfiguration> bootstrap) {
        bootstrap.setName("todo");
        bootstrap.addBundle(new AssetsBundle("/assets/", "/"));
    }

    @Override
    public void run(TodoConfiguration configuration, Environment environment) throws Exception {
        MongoClient mongoClient = new MongoClient();
        DB db = mongoClient.getDB("todos");
        TodosRepository todosRepository = new TodosRepositoryImpl(db.getCollection("todos"));
        environment.addResource(new TodoResource(todosRepository));
    }
}
