package org.joska.model.comment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joska.model.post.PostDomain;
import org.joska.model.user.domain.UserDomain;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comment")
@Entity
public class CommentDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_post_id")
    private PostDomain post;

    @Column(name= "name")
    private String name;

    @Column(name= "email")
    private String email;

    @Column(name= "body", length = 511)
    private String body;
}
