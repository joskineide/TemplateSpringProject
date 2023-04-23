package org.joska.model.user.placeholder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceholderUserAddressGeoDomain {
    private String lat;
    private String lng;
}

