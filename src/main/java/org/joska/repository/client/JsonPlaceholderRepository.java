package org.joska.repository.client;

import org.joska.model.album.PlaceholderAlbumDomain;
import org.joska.model.comment.PlaceholderCommentDomain;
import org.joska.model.photo.PlaceholderPhotoDomain;
import org.joska.model.post.PlaceholderPostDomain;
import org.joska.model.todo.PlaceholderTodoDomain;
import org.joska.model.user.placeholder.PlaceholderUserDomain;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "json-placeholder", url = "https://jsonplaceholder.typicode.com/")
public interface JsonPlaceholderRepository {
    @GetMapping(value = "/albums")
    List<PlaceholderAlbumDomain> getAlbums();
    @GetMapping(value = "/comments")
    List<PlaceholderCommentDomain> getComments();
    @GetMapping(value = "/photos")
    List<PlaceholderPhotoDomain> getPhotos();
    @GetMapping(value = "/posts")
    List<PlaceholderPostDomain> getPosts();
    @GetMapping(value = "/todos")
    List<PlaceholderTodoDomain> getTodos();
    @GetMapping(value = "/users")
    List<PlaceholderUserDomain> getUsers();

}
