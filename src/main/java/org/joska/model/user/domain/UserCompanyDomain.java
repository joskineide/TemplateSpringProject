package org.joska.model.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_company")
@Entity
public class UserCompanyDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "name")
    private String name;
    @Column(name= "catchPhrase")
    private String catchPhrase;
    @Column(name= "bs")
    private String bs;
}
