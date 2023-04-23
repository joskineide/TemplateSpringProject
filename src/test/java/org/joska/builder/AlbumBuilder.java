package org.joska.builder;

import org.joska.model.album.AlbumDomain;
import org.joska.model.album.AlbumRequest;
import org.joska.model.album.AlbumResponse;
import org.joska.model.album.PlaceholderAlbumDomain;

import java.util.Collections;

public class AlbumBuilder {

    public static AlbumResponse validResponse(){
        return AlbumResponse.builder()
                .id(1L)
                .userId(2L)
                .title("test_title")
                .photos(Collections.singletonList(PhotoBuilder.validResponse()))
                .build();
    }

    public static AlbumRequest validRequest(){
        return AlbumRequest.builder()
                .userId(2L)
                .title("test_title")
                .build();
    }

    public static AlbumDomain validCompleteDomain(){
        return AlbumDomain.builder()
                .id(1L)
                .user(UserBuilder.validDomain())
                .title("test_title")
                .photos(Collections.singletonList(PhotoBuilder.validSimpleDomain()))
                .build();
    }

    public static AlbumDomain validSimpleDomain(){
        return AlbumDomain.builder()
                .id(1L)
                .title("test_title")
                .photos(Collections.singletonList(PhotoBuilder.validSimpleDomain()))
                .build();
    }

    public static PlaceholderAlbumDomain validPlaceholder(){
        return PlaceholderAlbumDomain.builder()
                .userId(2L)
                .id(1L)
                .title("test_title")
                .build();
    }
}
