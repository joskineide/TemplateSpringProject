package org.joska.service;

import org.joska.builder.PhotoBuilder;
import org.joska.builder.AlbumBuilder;
import org.joska.mapper.PhotoConverter;
import org.joska.model.photo.PhotoDomain;
import org.joska.model.photo.PhotoRequest;
import org.joska.model.photo.PhotoResponse;
import org.joska.model.album.AlbumDomain;
import org.joska.repository.PhotoRepository;
import org.joska.repository.AlbumRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class PhotoServiceTest {
    @InjectMocks
    private PhotoService target;
    @Mock
    private PhotoRepository repository;
    @Mock
    private AlbumRepository albumRepository;
    @Mock
    private PhotoConverter converter;

    private Long id;
    private Long albumId;
    private PhotoResponse response;
    private PhotoRequest request;
    private PhotoDomain domain;
    private AlbumDomain albumDomain;

    @BeforeEach
    public void init(){
        id = 3L;
        albumId = 1L;
        response = PhotoBuilder.validResponse();
        request = PhotoBuilder.validRequest();
        domain = PhotoBuilder.validCompleteDomain();
        albumDomain = AlbumBuilder.validCompleteDomain();
    }
    @Test
    public void shouldGetById(){
        when(repository.findById(id)).thenReturn(Optional.of(domain));
        when(converter.domainToResponse(domain)).thenReturn(response);

        PhotoResponse result = target.getById(id);

        verify(repository).findById(id);
        verify(converter).domainToResponse(domain);
        assertEquals(response, result);
    }

    @Test
    public void shouldGetByIdNotFound(){
        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () ->  target.getById(id));

        verify(repository).findById(id);
        verify(converter, never()).domainToResponse(domain);

    }

    @Test
    public void shouldListAll(){
        when(repository.findAll()).thenReturn(Collections.singletonList(domain));
        when(converter.domainToResponse(domain)).thenReturn(response);

        List<PhotoResponse> result = target.listAll();

        verify(repository).findAll();
        verify(converter).domainToResponse(domain);
        assertEquals(Collections.singletonList(response), result);
    }


    @Test
    public void shouldCreate(){
        when(albumRepository.findById(albumId)).thenReturn(Optional.of(albumDomain));
        when(converter.requestToDomain(request)).thenReturn(domain);
        when(repository.save(domain)).thenReturn(domain);
        when(converter.domainToResponse(domain)).thenReturn(response);

        PhotoResponse result = target.create(request);

        verify(albumRepository).findById(albumId);
        verify(converter).requestToDomain(request);
        verify(repository).save(domain);
        verify(converter).domainToResponse(domain);
        assertEquals(response, result);
    }


    @Test
    public void shouldCreateAlbumNotFound(){
        when(albumRepository.findById(albumId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () ->  target.create(request));

        verify(albumRepository).findById(albumId);
        verify(converter, never()).requestToDomain(request);
    }

    @Test
    public void shouldUpdate(){
        when(albumRepository.findById(albumId)).thenReturn(Optional.of(albumDomain));
        when(repository.findById(id)).thenReturn(Optional.of(domain));
        when(converter.requestToDomain(request)).thenReturn(domain);
        when(repository.save(domain)).thenReturn(domain);
        when(converter.domainToResponse(domain)).thenReturn(response);

        PhotoResponse result = target.update(id, request);

        verify(albumRepository).findById(albumId);
        verify(repository).findById(id);
        verify(converter).requestToDomain(request);
        verify(repository).save(domain);
        verify(converter).domainToResponse(domain);
        assertEquals(response, result);
    }


    @Test
    public void shouldUpdateAlbumNotFound(){
        when(albumRepository.findById(albumId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () ->  target.update(id, request));

        verify(albumRepository).findById(albumId);
        verify(repository, never()).findById(id);
    }

    @Test
    public void shouldUpdateNotFound(){
        when(albumRepository.findById(albumId)).thenReturn(Optional.of(albumDomain));
        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () ->  target.update(id, request));

        verify(albumRepository).findById(albumId);
        verify(repository).findById(id);
        verify(converter, never()).requestToDomain(request);
    }

    @Test
    public void shouldDelete(){
        when(repository.findById(id)).thenReturn(Optional.of(domain));

        target.delete(id);

        verify(repository).findById(id);
        verify(repository).deleteById(id);
    }

    @Test
    public void shouldDeleteNotFound(){
        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () ->  target.delete(id));

        verify(repository).findById(id);
        verify(repository, never()).deleteById(id);
    }
}
