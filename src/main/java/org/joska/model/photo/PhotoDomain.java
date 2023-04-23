package org.joska.model.photo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joska.model.album.AlbumDomain;
import org.joska.model.post.PostDomain;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "photo")
@Entity
public class PhotoDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_album_id")
    private AlbumDomain album;

    @Column(name= "title")
    private String title;

    @Column(name= "url")
    private String url;

    @Column(name= "thumbnailUrl")
    private String thumbnailUrl;
}
