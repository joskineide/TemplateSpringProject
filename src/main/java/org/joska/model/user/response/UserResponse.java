package org.joska.model.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joska.model.album.AlbumResponse;
import org.joska.model.post.PostResponse;
import org.joska.model.todo.TodoResponse;
import org.joska.model.user.placeholder.PlaceholderUserAddressDomain;
import org.joska.model.user.placeholder.PlaceholderUserCompanyDomain;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String name;
    private String username;
    private String email;
    private UserAddressResponse address;
    private String phone;
    private String website;
    private UserCompanyResponse company;
    private List<AlbumResponse> albums;
    private List<PostResponse> posts;
    private List<TodoResponse> todos;
}
