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
@Table(name = "user_address")
@Entity
public class UserAddressDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "street")
    private String street;
    @Column(name= "suite")
    private String suite;
    @Column(name= "city")
    private String city;
    @Column(name= "zipcode")
    private String zipcode;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_geo_id", referencedColumnName = "id")
    private UserAddressGeoDomain geo;
}
