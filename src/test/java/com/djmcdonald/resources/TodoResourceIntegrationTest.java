package com.djmcdonald.resources;

import com.djmcdonald.model.Todo;
import com.djmcdonald.repositories.TodosRepository;
import com.google.common.collect.Lists;
import com.yammer.dropwizard.testing.ResourceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static com.google.common.collect.Lists.*;
import static com.yammer.dropwizard.testing.JsonHelpers.asJson;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TodoResourceIntegrationTest extends ResourceTest {

    @Mock
    private TodosRepository todosRepository;

    @Override
    protected void setUpResources() throws Exception {
        when(todosRepository.todos()).thenReturn(newArrayList(new Todo("1"), new Todo("2")));
        addResource(new TodoResource(todosRepository));
    }

    @Test
    public void shouldReturnASingleTodo() throws Exception {
        Todo expectedTodo = new Todo("1");

        assertThat(client().resource("/todos/1").get(Todo.class))
            .isEqualTo(expectedTodo);
    }

    @Test
    public void shouldReturnAListOfTodos() throws Exception {
        List<Todo> expectedTodos = newArrayList(new Todo("1"), new Todo("2"));

        assertThat(client().resource("/todos").get(String.class))
            .isEqualTo(asJson(expectedTodos));
    }
}
