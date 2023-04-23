package org.joska.model.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joska.model.user.placeholder.PlaceholderUserAddressGeoDomain;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAddressResponse {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private UserAddressGeoResponse geo;
}
