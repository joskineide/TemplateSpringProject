package org.joska.builder;

import org.joska.model.todo.TodoDomain;
import org.joska.model.todo.TodoRequest;
import org.joska.model.todo.TodoResponse;
import org.joska.model.todo.PlaceholderTodoDomain;

public class TodoBuilder {

    public static TodoResponse validResponse(){
        return TodoResponse.builder()
                .id(5L)
                .userId(2L)
                .title("test_title")
                .completed(true)
                .build();
    }

    public static TodoRequest validRequest(){
        return TodoRequest.builder()
                .userId(2L)
                .title("test_title")
                .completed(true)
                .build();
    }

    public static TodoDomain validCompleteDomain(){
        return TodoDomain.builder()
                .id(5L)
                .user(UserBuilder.validDomain())
                .title("test_title")
                .completed(true)
                .build();
    }

    public static TodoDomain validSimpleDomain(){
        return TodoDomain.builder()
                .id(5L)
                .title("test_title")
                .completed(true)
                .build();
    }

    public static PlaceholderTodoDomain validPlaceholder(){
        return PlaceholderTodoDomain.builder()
                .userId(2L)
                .id(5L)
                .title("test_title")
                .build();
    }
}
