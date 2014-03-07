package com.djmcdonald.resources;

import com.djmcdonald.model.Todo;
import com.yammer.dropwizard.testing.ResourceTest;
import org.junit.Test;

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
}
