package org.joska.repository;

import org.joska.model.album.AlbumDomain;
import org.joska.model.post.PostDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostDomain, Long> {
}
