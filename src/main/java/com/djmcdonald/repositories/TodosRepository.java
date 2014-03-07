package com.djmcdonald.repositories;

import com.djmcdonald.model.Todo;

import java.util.List;

public interface TodosRepository {
    List<Todo> todos();

    Todo todo(String id);
}
