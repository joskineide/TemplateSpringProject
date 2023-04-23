package org.joska.model.user.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joska.model.album.AlbumDomain;

import jakarta.persistence.*;
import org.joska.model.post.PostDomain;
import org.joska.model.todo.TodoDomain;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_entity")
@Entity
public class UserDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "name")
    private String name;
    @Column(name= "username")
    private String username;
    @Column(name= "email")
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_address_id", referencedColumnName = "id")
    private UserAddressDomain address;
    @Column(name= "phone")
    private String phone;
    @Column(name= "website")
    private String website;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_company_id", referencedColumnName = "id")
    private UserCompanyDomain company;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private List<AlbumDomain> albums;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private List<PostDomain> posts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private List<TodoDomain> todos;

}
