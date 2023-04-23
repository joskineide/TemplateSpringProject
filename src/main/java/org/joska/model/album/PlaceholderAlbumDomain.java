package org.joska.model.album;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceholderAlbumDomain {
    private Long userId;
    private Long id;
    private String title;
}
