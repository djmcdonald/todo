package com.djmcdonald.resources;

import com.djmcdonald.model.Todo;
import com.google.common.collect.Lists;
import com.yammer.dropwizard.testing.ResourceTest;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.*;
import static com.yammer.dropwizard.testing.JsonHelpers.asJson;
import static org.fest.assertions.Assertions.assertThat;

public class TodoResourceIntegrationTest extends ResourceTest {

    @Override
    protected void setUpResources() throws Exception {
        addResource(new TodoResource());
    }

    @Test
    public void shouldReturnASingleTodo() throws Exception {
        Todo expectedTodo = new Todo("1");

        assertThat(client().resource("/service/todos/1").get(Todo.class))
            .isEqualTo(expectedTodo);
    }

    @Test
    public void shouldReturnAListOfTodos() throws Exception {
        List<Todo> expectedTodos = newArrayList(new Todo("1"), new Todo("2"));

        assertThat(client().resource("/service/todos").get(String.class))
            .isEqualTo(asJson(expectedTodos));
    }
}
