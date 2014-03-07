package com.djmcdonald.resources

import com.djmcdonald.model.Todo
import spock.lang.Specification

class TodoResourceSpec extends Specification {
    def "it returns a basic todo object"() {
        given:
        def todoResource = new TodoResource()
        def id = "id"
        def expectedTodo = new Todo(id)

        when:
        def actualTodo = todoResource.getTodo(id)

        then:
        actualTodo == expectedTodo
    }
}
