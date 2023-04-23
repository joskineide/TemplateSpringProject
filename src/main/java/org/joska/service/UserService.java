package org.joska.service;

import lombok.RequiredArgsConstructor;
import org.joska.mapper.UserConverter;
import org.joska.model.album.AlbumDomain;
import org.joska.model.user.domain.UserDomain;
import org.joska.model.user.request.UserRequest;
import org.joska.model.user.response.UserResponse;
import org.joska.repository.AlbumRepository;
import org.joska.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final UserConverter converter;

    public UserResponse getById(Long id){
        UserDomain domain = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return converter.domainToResponse(domain);
    }

    public List<UserResponse> listAll(){
        List<UserDomain> domainList = repository.findAll();
        return domainList.stream().map(converter::domainToResponse).toList();
    }

    public UserResponse create(UserRequest request){
        UserDomain domain = converter.requestToDomain(request);

        domain = repository.save(domain);

        return converter.domainToResponse(domain);
    }

    public UserResponse update(Long id, UserRequest request){
        repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        UserDomain domain = converter.requestToDomain(request);
        domain.setId(id);

        domain = repository.save(domain);

        return converter.domainToResponse(domain);
    }

    public void delete(Long id){
        repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        repository.deleteById(id);
    }
}
