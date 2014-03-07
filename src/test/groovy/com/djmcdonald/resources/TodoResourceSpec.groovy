package com.djmcdonald.resources

import com.djmcdonald.model.Todo
import spock.lang.Specification

class TodoResourceSpec extends Specification {
    def "it returns a basic todo object"() {
        given:
        def todoResource = new TodoResource()
        def expectedTodo = new Todo("id")

        when:
        def actualTodo = todoResource.getTodo()

        then:
        actualTodo == expectedTodo
    }
}
