package org.joska.builder;


import org.joska.model.album.AlbumResponse;
import org.joska.model.post.PostResponse;
import org.joska.model.todo.TodoResponse;
import org.joska.model.user.domain.UserAddressDomain;
import org.joska.model.user.domain.UserAddressGeoDomain;
import org.joska.model.user.domain.UserCompanyDomain;
import org.joska.model.user.domain.UserDomain;
import org.joska.model.user.placeholder.PlaceholderUserAddressDomain;
import org.joska.model.user.placeholder.PlaceholderUserAddressGeoDomain;
import org.joska.model.user.placeholder.PlaceholderUserCompanyDomain;
import org.joska.model.user.placeholder.PlaceholderUserDomain;
import org.joska.model.user.request.UserAddressGeoRequest;
import org.joska.model.user.request.UserAddressRequest;
import org.joska.model.user.request.UserCompanyRequest;
import org.joska.model.user.request.UserRequest;
import org.joska.model.user.response.UserAddressGeoResponse;
import org.joska.model.user.response.UserAddressResponse;
import org.joska.model.user.response.UserCompanyResponse;
import org.joska.model.user.response.UserResponse;

import java.util.Collections;
import java.util.List;

public class UserBuilder {

    public static UserResponse validResponse(){
        return UserResponse.builder()
                .id(2L)
                .name("test_name")
                .username("test_username")
                .email("test_email")
                .address(UserAddressResponse.builder()
                        .street("test_street")
                        .suite("test_suite")
                        .city("test_city")
                        .zipcode("test_zipcode")
                        .geo(UserAddressGeoResponse.builder()
                                .lat("test_lat")
                                .lng("test_lng")
                                .build())

                        .build())
                .phone("test_phone")
                .website("test_website")
                .company(UserCompanyResponse.builder()
                        .name("test_company_name")
                        .catchPhrase("test_catch_phrase")
                        .bs("test_bs")
                        .build())
                .albums(Collections.singletonList(AlbumBuilder.validResponse()))
                .posts(Collections.singletonList(PostBuilder.validResponse()))
                .todos(Collections.singletonList(TodoBuilder.validResponse()))
                .build();

    }

    public static UserRequest validRequest(){
        return UserRequest.builder()
                .name("test_name")
                .username("test_username")
                .email("test_email")
                .address(UserAddressRequest.builder()
                        .street("test_street")
                        .suite("test_suite")
                        .city("test_city")
                        .zipcode("test_zipcode")
                        .geo(UserAddressGeoRequest.builder()
                                .lat("test_lat")
                                .lng("test_lng")
                                .build())

                        .build())
                .phone("test_phone")
                .website("test_website")
                .company(UserCompanyRequest.builder()
                        .name("test_company_name")
                        .catchPhrase("test_catch_phrase")
                        .bs("test_bs")
                        .build())
                .build();
    }

    public static UserDomain validDomain(){
        return UserDomain.builder()
                .id(2L)
                .name("test_name")
                .username("test_username")
                .email("test_email")
                .address(UserAddressDomain.builder()
                        .street("test_street")
                        .suite("test_suite")
                        .city("test_city")
                        .zipcode("test_zipcode")
                        .geo(UserAddressGeoDomain.builder()
                                .lat("test_lat")
                                .lng("test_lng")
                                .build())

                        .build())
                .phone("test_phone")
                .website("test_website")
                .company(UserCompanyDomain.builder()
                        .name("test_company_name")
                        .catchPhrase("test_catch_phrase")
                        .bs("test_bs")
                        .build())
                .albums(Collections.singletonList(AlbumBuilder.validSimpleDomain()))
                .posts(Collections.singletonList(PostBuilder.validSimpleDomain()))
                .todos(Collections.singletonList(TodoBuilder.validSimpleDomain()))
                .build();
    }

    public static PlaceholderUserDomain validPlaceholder(){
        return PlaceholderUserDomain.builder()
                .id(2L)
                .name("test_name")
                .username("test_username")
                .email("test_email")
                .address(PlaceholderUserAddressDomain.builder()
                        .street("test_street")
                        .suite("test_suite")
                        .city("test_city")
                        .zipcode("test_zipcode")
                        .geo(PlaceholderUserAddressGeoDomain.builder()
                                .lat("test_lat")
                                .lng("test_lng")
                                .build())

                        .build())
                .phone("test_phone")
                .website("test_website")
                .company(PlaceholderUserCompanyDomain.builder()
                        .name("test_company_name")
                        .catchPhrase("test_catch_phrase")
                        .bs("test_bs")
                        .build())
                .build();
    }
}
