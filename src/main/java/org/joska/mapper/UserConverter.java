package org.joska.mapper;

import lombok.RequiredArgsConstructor;
import org.joska.model.post.PostDomain;
import org.joska.model.post.PostRequest;
import org.joska.model.post.PostResponse;
import org.joska.model.user.domain.UserAddressDomain;
import org.joska.model.user.domain.UserAddressGeoDomain;
import org.joska.model.user.domain.UserCompanyDomain;
import org.joska.model.user.domain.UserDomain;
import org.joska.model.user.request.UserRequest;
import org.joska.model.user.response.UserAddressGeoResponse;
import org.joska.model.user.response.UserAddressResponse;
import org.joska.model.user.response.UserCompanyResponse;
import org.joska.model.user.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class
UserConverter {

    private final AlbumConverter albumConverter;
    private final PostConverter postConverter;
    private final TodoConverter todoConverter;

    public UserResponse domainToResponse(UserDomain domain) {
        return UserResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .username(domain.getUsername())
                .email(domain.getEmail())
                .address(Objects.nonNull(domain.getAddress()) ? UserAddressResponse.builder()
                                .street(domain.getAddress().getStreet())
                                .suite(domain.getAddress().getSuite())
                                .city(domain.getAddress().getCity())
                                .zipcode(domain.getAddress().getZipcode())
                                .geo(Objects.nonNull(domain.getAddress().getGeo()) ? UserAddressGeoResponse.builder()
                                        .lat(domain.getAddress().getGeo().getLat())
                                        .lng(domain.getAddress().getGeo().getLng())
                                        .build() : null)
                        .build() : null)
                .phone(domain.getPhone())
                .website(domain.getWebsite())
                .company(Objects.nonNull(domain.getCompany()) ? UserCompanyResponse.builder()
                        .name(domain.getCompany().getName())
                        .catchPhrase(domain.getCompany().getCatchPhrase())
                        .bs(domain.getCompany().getBs())
                        .build() : null)
                .albums(Objects.nonNull(domain.getAlbums()) ? domain.getAlbums()
                        .stream().map(albumConverter::domainToResponse).toList() : null)
                .posts(Objects.nonNull(domain.getPosts()) ? domain.getPosts()
                        .stream().map(postConverter::domainToResponse).toList() : null)
                .todos(Objects.nonNull(domain.getTodos()) ? domain.getTodos()
                        .stream().map(todoConverter::domainToResponse).toList() : null)
                .build();
    }

    public UserDomain requestToDomain(UserRequest request) {
        return UserDomain.builder()
                .name(request.getName())
                .username(request.getUsername())
                .email(request.getEmail())
                .address(Objects.nonNull(request.getAddress()) ? UserAddressDomain.builder()
                        .street(request.getAddress().getStreet())
                        .suite(request.getAddress().getSuite())
                        .city(request.getAddress().getCity())
                        .zipcode(request.getAddress().getZipcode())
                        .geo(Objects.nonNull(request.getAddress().getGeo()) ? UserAddressGeoDomain.builder()
                                .lat(request.getAddress().getGeo().getLat())
                                .lng(request.getAddress().getGeo().getLng())
                                .build() : null)
                        .build() : null)
                .phone(request.getPhone())
                .website(request.getWebsite())
                .company(Objects.nonNull(request.getCompany()) ? UserCompanyDomain.builder()
                        .name(request.getCompany().getName())
                        .catchPhrase(request.getCompany().getCatchPhrase())
                        .bs(request.getCompany().getBs())
                        .build() : null)
                .build();
    }
}
