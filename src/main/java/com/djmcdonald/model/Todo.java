package com.djmcdonald.model;

public class Todo {
    private String thing;

    public Todo() {
    }

    public Todo(String thing) {
        this.thing = thing;
    }

    public String getThing() {
        return thing;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "thing='" + thing + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Todo todo = (Todo) o;

        if (!thing.equals(todo.thing)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return thing.hashCode();
    }
}
