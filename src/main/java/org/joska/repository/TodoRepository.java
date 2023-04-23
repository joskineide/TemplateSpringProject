package org.joska.repository;

import org.joska.model.album.AlbumDomain;
import org.joska.model.todo.TodoDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoDomain, Long> {
}
