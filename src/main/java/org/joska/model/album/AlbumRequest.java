package org.joska.model.album;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joska.model.photo.PhotoRequest;


import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlbumRequest {
    @NotNull
    private Long userId;
    @NotNull
    private String title;
}
