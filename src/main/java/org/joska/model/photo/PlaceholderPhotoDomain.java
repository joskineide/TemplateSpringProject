package org.joska.model.photo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceholderPhotoDomain {
    private Long albumId;
    private Long id;
    private String title;
    private String url;
    private String thumbnailUrl;
}
