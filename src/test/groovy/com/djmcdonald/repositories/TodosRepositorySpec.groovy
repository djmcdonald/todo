package com.djmcdonald.repositories

import com.djmcdonald.model.Todo
import com.mongodb.DBCollection
import com.mongodb.DBCursor
import com.mongodb.DBObject
import spock.lang.Specification

import static com.google.common.collect.Lists.newArrayList

class TodosRepositorySpec extends Specification {
    def 'it should retrieve a list of todos from a dao'() {
        given:
        def mockDbCursor = Mock(DBCursor.class)
        def expectedTodos = newArrayList(new Todo("1"))
        def mockDbCollection = Mock(DBCollection.class)
        mockDbCollection.find() >> mockDbCursor
        mockDbCursor.hasNext() >>> [ true, false ]
        def mockDbObject = Mock(DBObject.class)
        mockDbCursor.next() >> mockDbObject
        mockDbObject.get('thing') >> '1'
        def todosRepository = new TodosRepositoryImpl(mockDbCollection);

        when:
        def actualTodos = todosRepository.todos()

        then:
        actualTodos == expectedTodos
        1 * mockDbCursor.close()
    }
}
