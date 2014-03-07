package com.djmcdonald.repositories;

import com.djmcdonald.model.Todo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcdond06
 * Date: 07/03/2014
 * Time: 19:31
 * To change this template use File | Settings | File Templates.
 */
public interface TodosRepository {
    List<Todo> todos();
}
