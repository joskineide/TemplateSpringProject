package org.joska.model.user.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joska.model.user.response.UserAddressResponse;
import org.joska.model.user.response.UserCompanyResponse;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String name;
    private String username;
    private String email;
    private UserAddressRequest address;
    private String phone;
    private String website;
    private UserCompanyRequest company;
}
