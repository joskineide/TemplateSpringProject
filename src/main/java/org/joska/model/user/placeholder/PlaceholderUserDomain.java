package org.joska.model.user.placeholder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceholderUserDomain {
    private Long id;
    private String name;
    private String username;
    private String email;
    private PlaceholderUserAddressDomain address;
    private String phone;
    private String website;
    private PlaceholderUserCompanyDomain company;
}
