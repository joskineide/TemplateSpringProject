package org.joska.repository;

import org.joska.model.comment.CommentDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentDomain, Long> {
}
