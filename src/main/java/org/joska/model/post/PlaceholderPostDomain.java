package org.joska.model.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceholderPostDomain {
    private Long userId;
    private Long id;
    private String title;
    private String body;
}
