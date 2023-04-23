package org.joska.service;

import org.joska.builder.CommentBuilder;
import org.joska.builder.PostBuilder;
import org.joska.mapper.CommentConverter;
import org.joska.model.comment.CommentDomain;
import org.joska.model.comment.CommentRequest;
import org.joska.model.comment.CommentResponse;
import org.joska.model.post.PostDomain;
import org.joska.repository.CommentRepository;
import org.joska.repository.PostRepository;
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
public class CommentServiceTest {
    @InjectMocks
    private CommentService target;
    @Mock
    private CommentRepository repository;
    @Mock
    private PostRepository postRepository;
    @Mock
    private CommentConverter converter;

    private Long id;
    private Long postId;
    private CommentResponse response;
    private CommentRequest request;
    private CommentDomain domain;

    private PostDomain postDomain;

    @BeforeEach
    public void init(){
        id = 6L;
        postId = 4L;
        response = CommentBuilder.validResponse();
        request = CommentBuilder.validRequest();
        domain = CommentBuilder.validCompleteDomain();
        postDomain = PostBuilder.validCompleteDomain();
    }
    @Test
    public void shouldGetById(){
        when(repository.findById(id)).thenReturn(Optional.of(domain));
        when(converter.domainToResponse(domain)).thenReturn(response);

        CommentResponse result = target.getById(id);

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

        List<CommentResponse> result = target.listAll();

        verify(repository).findAll();
        verify(converter).domainToResponse(domain);
        assertEquals(Collections.singletonList(response), result);
    }


    @Test
    public void shouldCreate(){
        when(postRepository.findById(postId)).thenReturn(Optional.of(postDomain));
        when(converter.requestToDomain(request)).thenReturn(domain);
        when(repository.save(domain)).thenReturn(domain);
        when(converter.domainToResponse(domain)).thenReturn(response);

        CommentResponse result = target.create(request);

        verify(postRepository).findById(postId);
        verify(converter).requestToDomain(request);
        verify(repository).save(domain);
        verify(converter).domainToResponse(domain);
        assertEquals(response, result);
    }


    @Test
    public void shouldCreatePostNotFound(){
        when(postRepository.findById(postId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () ->  target.create(request));

        verify(postRepository).findById(postId);
        verify(converter, never()).requestToDomain(request);
    }

    @Test
    public void shouldUpdate(){
        when(postRepository.findById(postId)).thenReturn(Optional.of(postDomain));
        when(repository.findById(id)).thenReturn(Optional.of(domain));
        when(converter.requestToDomain(request)).thenReturn(domain);
        when(repository.save(domain)).thenReturn(domain);
        when(converter.domainToResponse(domain)).thenReturn(response);

        CommentResponse result = target.update(id, request);

        verify(postRepository).findById(postId);
        verify(repository).findById(id);
        verify(converter).requestToDomain(request);
        verify(repository).save(domain);
        verify(converter).domainToResponse(domain);
        assertEquals(response, result);
    }


    @Test
    public void shouldUpdatePostNotFound(){
        when(postRepository.findById(postId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () ->  target.update(id, request));

        verify(postRepository).findById(postId);
        verify(repository, never()).findById(id);
    }

    @Test
    public void shouldUpdateNotFound(){
        when(postRepository.findById(postId)).thenReturn(Optional.of(postDomain));
        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () ->  target.update(id, request));

        verify(postRepository).findById(postId);
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
