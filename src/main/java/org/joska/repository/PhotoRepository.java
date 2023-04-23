package org.joska.repository;

import org.joska.model.album.AlbumDomain;
import org.joska.model.photo.PhotoDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<PhotoDomain, Long> {
}
