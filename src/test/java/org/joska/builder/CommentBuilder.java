package org.joska.builder;

import org.joska.model.comment.CommentDomain;
import org.joska.model.comment.CommentRequest;
import org.joska.model.comment.CommentResponse;
import org.joska.model.comment.PlaceholderCommentDomain;

public class CommentBuilder {

    public static CommentResponse validResponse(){
        return CommentResponse.builder()
                .id(6L)
                .postId(4L)
                .name("test_name")
                .email("test_email")
                .body("test_body")
                .build();
    }

    public static CommentRequest validRequest(){
        return CommentRequest.builder()
                .postId(4L)
                .name("test_name")
                .email("test_email")
                .body("test_body")
                .build();
    }

    public static CommentDomain validCompleteDomain(){
        return CommentDomain.builder()
                .id(6L)
                .post(PostBuilder.validSimpleDomain())
                .name("test_name")
                .email("test_email")
                .body("test_body")
                .build();
    }

    public static CommentDomain validSimpleDomain(){
        return CommentDomain.builder()
                .id(6L)
                .name("test_name")
                .email("test_email")
                .body("test_body")
                .build();
    }

    public static PlaceholderCommentDomain validPlaceholder(){
        return PlaceholderCommentDomain.builder()
                .id(6L)
                .postId(4L)
                .name("test_name")
                .email("test_email")
                .body("test_body")
                .build();
    }
}
