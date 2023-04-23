package org.joska.model.user.placeholder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceholderUserAddressDomain {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private PlaceholderUserAddressGeoDomain geo;

}
