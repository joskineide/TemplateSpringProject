package org.joska.mapper;

import lombok.RequiredArgsConstructor;
import org.joska.model.post.PostDomain;
import org.joska.model.post.PostRequest;
import org.joska.model.post.PostResponse;
import org.joska.model.todo.TodoDomain;
import org.joska.model.todo.TodoRequest;
import org.joska.model.todo.TodoResponse;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class TodoConverter {
    public TodoResponse domainToResponse(TodoDomain domain) {
        return TodoResponse.builder()
                .userId(Objects.nonNull(domain.getUser()) ? domain.getUser().getId() : null)
                .id(domain.getId())
                .title(domain.getTitle())
                .completed(domain.getCompleted())
                .build();
    }

    public TodoDomain requestToDomain(TodoRequest request) {
        return TodoDomain.builder()
                .title(request.getTitle())
                .completed(request.getCompleted())
                .build();
    }
}
