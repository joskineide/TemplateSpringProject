package org.joska.model.album;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joska.model.photo.PhotoDomain;
import org.joska.model.photo.PhotoResponse;
import org.joska.model.user.domain.UserDomain;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlbumResponse {

    private Long id;
    private Long userId;
    private String title;
    private List<PhotoResponse> photos;
}
