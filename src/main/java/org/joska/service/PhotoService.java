package org.joska.service;

import lombok.RequiredArgsConstructor;
import org.joska.mapper.PhotoConverter;
import org.joska.model.album.AlbumDomain;
import org.joska.model.photo.PhotoDomain;
import org.joska.model.photo.PhotoRequest;
import org.joska.model.photo.PhotoResponse;
import org.joska.model.post.PostDomain;
import org.joska.repository.AlbumRepository;
import org.joska.repository.PhotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoService {
    private final PhotoRepository repository;
    private final PhotoConverter converter;
    private final AlbumRepository albumRepository;

    public PhotoResponse getById(Long id){
        PhotoDomain domain = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Photo not found"));
        return converter.domainToResponse(domain);
    }

    public List<PhotoResponse> listAll(){
        List<PhotoDomain> domainList = repository.findAll();
        return domainList.stream().map(converter::domainToResponse).toList();
    }

    public PhotoResponse create(PhotoRequest request){
        AlbumDomain album = albumRepository.findById(request.getAlbumId())
                .orElseThrow(() -> new RuntimeException("Album not found!"));
        PhotoDomain domain = converter.requestToDomain(request);
        domain.setAlbum(album);

        domain = repository.save(domain);

        return converter.domainToResponse(domain);
    }

    public PhotoResponse update(Long id, PhotoRequest request){
        AlbumDomain album = albumRepository.findById(request.getAlbumId())
                .orElseThrow(() -> new RuntimeException("Album not found!"));
        repository.findById(id).orElseThrow(() -> new RuntimeException("Photo not found"));
        PhotoDomain domain = converter.requestToDomain(request);
        domain.setAlbum(album);
        domain.setId(id);

        domain = repository.save(domain);

        return converter.domainToResponse(domain);
    }

    public void delete(Long id){
        repository.findById(id).orElseThrow(() -> new RuntimeException("Photo not found"));
        repository.deleteById(id);
    }
}
