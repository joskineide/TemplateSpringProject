package org.joska.model.user.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joska.model.user.response.UserAddressGeoResponse;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAddressRequest {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private UserAddressGeoRequest geo;
}
