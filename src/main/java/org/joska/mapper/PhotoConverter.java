package org.joska.mapper;

import lombok.RequiredArgsConstructor;
import org.joska.model.album.AlbumDomain;
import org.joska.model.album.AlbumResponse;
import org.joska.model.photo.PhotoDomain;
import org.joska.model.photo.PhotoRequest;
import org.joska.model.photo.PhotoResponse;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class PhotoConverter {
    public PhotoResponse domainToResponse(PhotoDomain domain){
        return PhotoResponse.builder()
                .id(domain.getId())
                .albumId(Objects.nonNull(domain.getAlbum()) ? domain.getAlbum().getId() : null)
                .title(domain.getTitle())
                .url(domain.getUrl())
                .thumbnailUrl(domain.getThumbnailUrl())
                .build();
    }

    public PhotoDomain requestToDomain(PhotoRequest request){
        return PhotoDomain.builder()
                .title(request.getTitle())
                .url(request.getUrl())
                .thumbnailUrl(request.getThumbnailUrl())
                .build();
    }
}
