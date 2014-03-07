package com.djmcdonald.repositories;

import com.djmcdonald.model.Todo;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class TodosRepositoryImpl implements TodosRepository {

    private final DBCollection dbCollection;

    public TodosRepositoryImpl(DBCollection dbCollection) {
        this.dbCollection = dbCollection;
    }

    @Override
    public List<Todo> todos() {
        DBCursor dbCursor = dbCollection.find();
        List<Todo> todos = newArrayList();

        while (dbCursor.hasNext()) {
            DBObject dbObject = dbCursor.next();
            Todo todo = new Todo((String) dbObject.get("thing"));
            todos.add(todo);
        }

        return todos;
    }
}
