package org.joska.mapper;

import lombok.RequiredArgsConstructor;
import org.joska.model.comment.CommentDomain;
import org.joska.model.comment.CommentRequest;
import org.joska.model.comment.CommentResponse;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CommentConverter {
    public CommentResponse domainToResponse(CommentDomain domain) {
        return CommentResponse.builder()
                .postId(Objects.nonNull(domain.getPost()) ? domain.getPost().getId() : null)
                .id(domain.getId())
                .name(domain.getName())
                .email(domain.getEmail())
                .body(domain.getBody())
                .build();
    }

    public CommentDomain requestToDomain(CommentRequest request) {
        return CommentDomain.builder()
                .name(request.getName())
                .email(request.getEmail())
                .body(request.getBody())
                .build();
    }
}
