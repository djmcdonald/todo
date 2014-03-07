package com.djmcdonald.resources

import com.djmcdonald.model.Todo
import com.djmcdonald.repositories.TodosRepositoryImpl
import spock.lang.Specification

import static com.google.common.collect.Lists.newArrayList

class TodoResourceSpec extends Specification {
    def "it returns a basic todo object"() {
        given:
        def mockTodoRepository = Mock(TodosRepositoryImpl.class)
        def todoResource = new TodoResource(mockTodoRepository)
        def id = "thing"
        def expectedTodo = new Todo(id)

        when:
        def actualTodo = todoResource.todo(id)

        then:
        actualTodo == expectedTodo
    }

    def 'it returns a list of todos'() {
        given:
        def mockTodoRepository = Mock(TodosRepositoryImpl.class)
        def expectedTodos = newArrayList(new Todo("1"), new Todo("2"))
        mockTodoRepository.todos() >> expectedTodos;
        def todoResource = new TodoResource(mockTodoRepository);

        when:
        def actualTodos = todoResource.todos()

        then:
        expectedTodos == actualTodos
    }
}
