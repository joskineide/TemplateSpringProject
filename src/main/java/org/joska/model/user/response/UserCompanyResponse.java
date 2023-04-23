package org.joska.model.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCompanyResponse {
    private String name;
    private String catchPhrase;
    private String bs;
}
