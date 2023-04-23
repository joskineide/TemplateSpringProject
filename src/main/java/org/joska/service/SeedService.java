package org.joska.service;


import lombok.RequiredArgsConstructor;
import org.joska.model.album.AlbumDomain;
import org.joska.model.album.PlaceholderAlbumDomain;
import org.joska.model.comment.CommentDomain;
import org.joska.model.comment.PlaceholderCommentDomain;
import org.joska.model.photo.PhotoDomain;
import org.joska.model.photo.PlaceholderPhotoDomain;
import org.joska.model.post.PlaceholderPostDomain;
import org.joska.model.post.PostDomain;
import org.joska.model.todo.PlaceholderTodoDomain;
import org.joska.model.todo.TodoDomain;
import org.joska.model.user.domain.UserAddressDomain;
import org.joska.model.user.domain.UserAddressGeoDomain;
import org.joska.model.user.domain.UserCompanyDomain;
import org.joska.model.user.domain.UserDomain;
import org.joska.model.user.placeholder.PlaceholderUserDomain;
import org.joska.repository.*;
import org.joska.repository.client.JsonPlaceholderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeedService {
    private final JsonPlaceholderRepository jsonPlaceholderRepository;
    private final AlbumRepository albumRepository;
    private final CommentRepository commentRepository;
    private final PhotoRepository photoRepository;
    private final PostRepository postRepository;
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public List<UserDomain> seedFromPlaceholder(){
        List<PlaceholderAlbumDomain> placeholderAlbums = jsonPlaceholderRepository.getAlbums();
        List<PlaceholderCommentDomain> placeholderComments = jsonPlaceholderRepository.getComments();
        List<PlaceholderPhotoDomain> placeholderPhotos = jsonPlaceholderRepository.getPhotos();
        List<PlaceholderPostDomain> placeholderPosts = jsonPlaceholderRepository.getPosts();
        List<PlaceholderTodoDomain> placeholderTodos = jsonPlaceholderRepository.getTodos();
        List<PlaceholderUserDomain> placeholderUsers = jsonPlaceholderRepository.getUsers();

        userRepository.deleteAll();

        placeholderUsers.forEach(user -> {
            UserDomain userDomain = UserDomain.builder()
                    .name(user.getName())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .address(UserAddressDomain.builder()
                            .street(user.getAddress().getStreet())
                            .suite(user.getAddress().getSuite())
                            .city(user.getAddress().getCity())
                            .zipcode(user.getAddress().getZipcode())
                            .geo(UserAddressGeoDomain.builder()
                                    .lat(user.getAddress().getGeo().getLat())
                                    .lng(user.getAddress().getGeo().getLng())
                                    .build())
                            .build())
                    .phone(user.getPhone())
                    .website(user.getWebsite())
                    .company(UserCompanyDomain.builder()
                            .name(user.getCompany().getName())
                            .catchPhrase(user.getCompany().getCatchPhrase())
                            .bs(user.getCompany().getBs())
                            .build())
                    .build();

            userDomain = userRepository.save(userDomain);


            UserDomain finalUserDomain = userDomain;
            placeholderAlbums.stream()
                    .filter(album -> album.getUserId().equals(user.getId()))
                    .forEach(album -> {
                        AlbumDomain albumDomain = AlbumDomain.builder()
                                .user(finalUserDomain)
                                .title(album.getTitle())
                                .build();
                        albumDomain = albumRepository.save(albumDomain);


                        AlbumDomain finalAlbumDomain = albumDomain;
                        List<PhotoDomain> photoDomains = placeholderPhotos.stream()
                                    .filter(photo -> photo.getAlbumId().equals(album.getId()))
                                    .map(photo -> PhotoDomain.builder()
                                            .title(photo.getTitle())
                                            .url(photo.getUrl())
                                            .thumbnailUrl(photo.getThumbnailUrl())
                                            .album(finalAlbumDomain)
                                            .build())
                                    .toList();

                        photoRepository.saveAll(photoDomains);
                    });

            placeholderPosts.stream()
                .filter(post -> post.getUserId().equals(user.getId()))
                .forEach(post -> {
                    PostDomain postDomain = PostDomain.builder()
                            .user(finalUserDomain)
                            .title(post.getTitle())
                            .body(post.getBody())
                            .build();

                    postDomain = postRepository.save(postDomain);

                    PostDomain finalPostDomain = postDomain;
                    List<CommentDomain> commentDomains = placeholderComments.stream()
                                .filter(comment -> comment.getPostId().equals(post.getId()))
                                .map(comment -> CommentDomain.builder()
                                        .post(finalPostDomain)
                                        .name(comment.getName())
                                        .email(comment.getEmail())
                                        .body(comment.getBody())
                                        .build())
                                .toList();

                    commentRepository.saveAll(commentDomains);
                });

                List<TodoDomain> todoDomains =  placeholderTodos.stream()
                        .filter(todo -> todo.getUserId().equals(user.getId()))
                        .map(todo -> TodoDomain.builder()
                                .user(finalUserDomain)
                                .title(todo.getTitle())
                                .completed(todo.getCompleted())
                                .build())
                        .toList();

                todoRepository.saveAll(todoDomains);

            });


        return userRepository.findAll();
    }
}
