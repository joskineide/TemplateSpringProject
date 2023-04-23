package org.joska.service;

import lombok.RequiredArgsConstructor;
import org.joska.mapper.AlbumConverter;
import org.joska.model.album.AlbumDomain;
import org.joska.model.album.AlbumRequest;
import org.joska.model.album.AlbumResponse;
import org.joska.model.user.domain.UserDomain;
import org.joska.repository.AlbumRepository;
import org.joska.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final AlbumRepository repository;
    private final UserRepository userRepository;
    private final AlbumConverter converter;

    public AlbumResponse getById(Long id){
        AlbumDomain domain = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Album not found"));
        return converter.domainToResponse(domain);
    }

    public List<AlbumResponse> listAll(){
        List<AlbumDomain> domainList = repository.findAll();
        return domainList.stream().map(converter::domainToResponse).toList();
    }

    public AlbumResponse create(AlbumRequest request){
        UserDomain user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found!"));
        AlbumDomain domain = converter.requestToDomain(request);
        domain.setUser(user);

        domain = repository.save(domain);

        return converter.domainToResponse(domain);
    }

    public AlbumResponse update(Long id, AlbumRequest request){
        UserDomain user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found!"));
        AlbumDomain oldDomain = repository.findById(id).orElseThrow(() -> new RuntimeException("Album not found"));
        AlbumDomain domain = converter.requestToDomain(request);
        domain.setUser(user);
        domain.setId(id);
        domain.setPhotos(oldDomain.getPhotos());

        domain = repository.save(domain);

        return converter.domainToResponse(domain);
    }

    public void delete(Long id){
        repository.findById(id).orElseThrow(() -> new RuntimeException("Album not found"));
        repository.deleteById(id);
    }
}
