package org.joska.model.photo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joska.model.album.AlbumDomain;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhotoRequest {

    private Long albumId;
    @NotNull
    private String title;
    @NotNull
    private String url;
    @NotNull
    private String thumbnailUrl;
}
