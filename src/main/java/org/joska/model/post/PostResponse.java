package org.joska.model.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joska.model.comment.CommentDomain;
import org.joska.model.comment.CommentResponse;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {
    private Long userId;
    private Long id;
    private String title;
    private String body;
    private List<CommentResponse> comments;
}
