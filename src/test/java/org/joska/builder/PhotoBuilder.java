package org.joska.builder;

import org.joska.model.photo.PhotoDomain;
import org.joska.model.photo.PhotoRequest;
import org.joska.model.photo.PhotoResponse;
import org.joska.model.photo.PlaceholderPhotoDomain;

public class PhotoBuilder {

    public static PhotoResponse validResponse(){
        return PhotoResponse.builder()
                .id(3L)
                .albumId(1L)
                .title("test_title_photo")
                .url("test_url")
                .thumbnailUrl("test_thumbnail_url")
                .build();
    }

    public static PhotoRequest validRequest(){
        return PhotoRequest.builder()
                .albumId(1L)
                .title("test_title_photo")
                .url("test_url")
                .thumbnailUrl("test_thumbnail_url")
                .build();
    }

    public static PhotoDomain validCompleteDomain(){
        return PhotoDomain.builder()
                .id(3L)
                .album(AlbumBuilder.validSimpleDomain())
                .title("test_title_photo")
                .url("test_url")
                .thumbnailUrl("test_thumbnail_url")
                .build();
    }

    public static PhotoDomain validSimpleDomain(){
        return PhotoDomain.builder()
                .id(3L)
                .title("test_title_photo")
                .url("test_url")
                .thumbnailUrl("test_thumbnail_url")
                .build();
    }

    public static PlaceholderPhotoDomain validPlaceholder(){
        return PlaceholderPhotoDomain.builder()
                .id(3L)
                .albumId(1L)
                .title("test_title_photo")
                .url("test_url")
                .thumbnailUrl("test_thumbnail_url")
                .build();
    }
}
