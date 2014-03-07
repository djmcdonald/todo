package com.djmcdonald.resources

import com.djmcdonald.model.Todo
import spock.lang.Specification

import static com.google.common.collect.Lists.newArrayList

class TodoResourceSpec extends Specification {
    def "it returns a basic todo object"() {
        given:
        def todoResource = new TodoResource()
        def id = "id"
        def expectedTodo = new Todo(id)

        when:
        def actualTodo = todoResource.todo(id)

        then:
        actualTodo == expectedTodo
    }

    def 'it returns a list of todos'() {
        given:
        def expectedTodos = newArrayList(new Todo("1"), new Todo("2"))
        def todoResource = new TodoResource();

        when:
        def actualTodos = todoResource.todos()

        then:
        expectedTodos == actualTodos
    }
}
