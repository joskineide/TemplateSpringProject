package org.joska.service;

import org.joska.builder.UserBuilder;
import org.joska.mapper.UserConverter;
import org.joska.model.user.domain.UserDomain;
import org.joska.model.user.request.UserRequest;
import org.joska.model.user.response.UserResponse;
import org.joska.repository.UserRepository;
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
public class UserServiceTest {
    @InjectMocks
    private UserService target;
    @Mock
    private UserRepository repository;
    @Mock
    private UserConverter converter;

    private Long id;
    private UserResponse response;
    private UserRequest request;
    private UserDomain domain;


    @BeforeEach
    public void init(){
        id = 2L;
        response = UserBuilder.validResponse();
        request = UserBuilder.validRequest();
        domain = UserBuilder.validDomain();
    }
    @Test
    public void shouldGetById(){
        when(repository.findById(id)).thenReturn(Optional.of(domain));
        when(converter.domainToResponse(domain)).thenReturn(response);

        UserResponse result = target.getById(id);

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

        List<UserResponse> result = target.listAll();

        verify(repository).findAll();
        verify(converter).domainToResponse(domain);
        assertEquals(Collections.singletonList(response), result);
    }


    @Test
    public void shouldCreate(){
        when(converter.requestToDomain(request)).thenReturn(domain);
        when(repository.save(domain)).thenReturn(domain);
        when(converter.domainToResponse(domain)).thenReturn(response);

        UserResponse result = target.create(request);

        verify(converter).requestToDomain(request);
        verify(repository).save(domain);
        verify(converter).domainToResponse(domain);
        assertEquals(response, result);
    }




    @Test
    public void shouldUpdate(){
        when(repository.findById(id)).thenReturn(Optional.of(domain));
        when(converter.requestToDomain(request)).thenReturn(domain);
        when(repository.save(domain)).thenReturn(domain);
        when(converter.domainToResponse(domain)).thenReturn(response);

        UserResponse result = target.update(id, request);

        verify(repository).findById(id);
        verify(converter).requestToDomain(request);
        verify(repository).save(domain);
        verify(converter).domainToResponse(domain);
        assertEquals(response, result);
    }


    @Test
    public void shouldUpdateNotFound(){
        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () ->  target.update(id, request));

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
