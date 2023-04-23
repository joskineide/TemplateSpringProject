package org.joska.repository;

import org.joska.model.album.AlbumDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumDomain, Long> {
}
