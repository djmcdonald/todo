package com.djmcdonald.model

import spock.lang.Specification

class TodoSpec extends Specification {

    def "it allows you to set the id"() {
        expect:
        'test' == (new Todo(id)).getThing()

        where:
        id = 'test'
    }
}
