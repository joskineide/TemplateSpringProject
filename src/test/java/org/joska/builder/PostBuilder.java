package org.joska.builder;

import org.joska.model.comment.CommentResponse;
import org.joska.model.post.PostDomain;
import org.joska.model.post.PostRequest;
import org.joska.model.post.PostResponse;
import org.joska.model.post.PlaceholderPostDomain;

import java.util.Collections;
import java.util.List;

public class PostBuilder {

    public static PostResponse validResponse(){
        return PostResponse.builder()
                .id(4L)
                .userId(2L)
                .title("test_title")
                .body("test_body")
                .comments(Collections.singletonList(CommentBuilder.validResponse()))
                .build();
    }

    public static PostRequest validRequest(){
        return PostRequest.builder()
                .userId(2L)
                .title("test_title")
                .body("test_body")
                .build();
    }

    public static PostDomain validCompleteDomain(){
        return PostDomain.builder()
                .id(4L)
                .user(UserBuilder.validDomain())
                .title("test_title")
                .body("test_body")
                .comments(Collections.singletonList(CommentBuilder.validSimpleDomain()))
                .build();
    }

    public static PostDomain validSimpleDomain(){
        return PostDomain.builder()
                .id(4L)
                .title("test_title")
                .body("test_body")
                .comments(Collections.singletonList(CommentBuilder.validSimpleDomain()))
                .build();
    }

    public static PlaceholderPostDomain validPlaceholder(){
        return PlaceholderPostDomain.builder()
                .id(4L)
                .userId(2L)
                .title("test_title")
                .body("test_body")
                .build();
    }
}
