package org.joska.mapper;

import lombok.RequiredArgsConstructor;
import org.joska.model.comment.CommentDomain;
import org.joska.model.comment.CommentRequest;
import org.joska.model.comment.CommentResponse;
import org.joska.model.post.PostDomain;
import org.joska.model.post.PostRequest;
import org.joska.model.post.PostResponse;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class PostConverter {

    private final CommentConverter commentConverter;

    public PostResponse domainToResponse(PostDomain domain) {
        return PostResponse.builder()
                .userId(Objects.nonNull(domain.getUser()) ? domain.getUser().getId() : null)
                .id(domain.getId())
                .title(domain.getTitle())
                .body(domain.getBody())
                .comments(Objects.nonNull(domain.getComments()) ? domain.getComments()
                        .stream().map(commentConverter::domainToResponse).toList() : null)
                .build();
    }

    public PostDomain requestToDomain(PostRequest request) {
        return PostDomain.builder()
                .title(request.getTitle())
                .body(request.getBody())
                .build();
    }
}
