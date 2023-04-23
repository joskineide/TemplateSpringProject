package org.joska.mapper;

import lombok.RequiredArgsConstructor;
import org.joska.model.album.AlbumDomain;
import org.joska.model.album.AlbumRequest;
import org.joska.model.album.AlbumResponse;
import org.joska.model.photo.PhotoResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class AlbumConverter {

    private final PhotoConverter photoConverter;
    public AlbumResponse domainToResponse(AlbumDomain domain){
        return AlbumResponse.builder()
                .id(domain.getId())
                .userId(Objects.nonNull(domain.getUser()) ? domain.getUser().getId() : null)
                .title(domain.getTitle())
                .photos(Objects.nonNull(domain.getPhotos()) ? domain.getPhotos().stream()
                        .map(photoConverter::domainToResponse).toList() : null)
                .build();
    }

    public AlbumDomain requestToDomain(AlbumRequest request){
        return AlbumDomain.builder()
                .title(request.getTitle())
                .build();
    }
}
