package com.djmcdonald.service;

import com.djmcdonald.config.TodoConfiguration;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class TodoService extends Service<TodoConfiguration> {
    public static void main(String[] args) throws Exception {
        new TodoService().run(args);
    }

    @Override
    public void initialize(Bootstrap<TodoConfiguration> bootstrap) {
        bootstrap.setName("todo");
    }

    @Override
    public void run(TodoConfiguration configuration, Environment environment) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
