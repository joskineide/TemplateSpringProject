package org.joska.model.album;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joska.model.comment.CommentDomain;
import org.joska.model.photo.PhotoDomain;
import org.joska.model.user.domain.UserDomain;

import jakarta.persistence.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "album")
@Entity
public class AlbumDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_user_id")
    private UserDomain user;

    @Column(name= "title")
    private String title;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "album", cascade = CascadeType.ALL)
    private List<PhotoDomain> photos;
}
