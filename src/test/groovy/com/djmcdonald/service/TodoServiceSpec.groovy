package com.djmcdonald.service

import com.djmcdonald.config.TodoConfiguration
import com.djmcdonald.resources.TodoResource
import com.yammer.dropwizard.config.Environment
import spock.lang.Specification

class TodoServiceSpec extends Specification {
    def 'should add todo resource to environment'() {
        given:
        def todoService = new TodoService()
        def mockEnvironment = Mock(Environment.class)
        def mockConfiguration = Mock(TodoConfiguration.class)

        when:
        todoService.run(mockConfiguration, mockEnvironment)

        then:
        1 * mockEnvironment.addResource(_ as TodoResource)
    }
}
