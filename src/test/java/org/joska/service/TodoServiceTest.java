package org.joska.service;

import org.joska.builder.TodoBuilder;
import org.joska.builder.UserBuilder;
import org.joska.mapper.TodoConverter;
import org.joska.model.todo.TodoDomain;
import org.joska.model.todo.TodoRequest;
import org.joska.model.todo.TodoResponse;
import org.joska.model.user.domain.UserDomain;
import org.joska.repository.TodoRepository;
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
public class TodoServiceTest {
    @InjectMocks
    private TodoService target;
    @Mock
    private TodoRepository repository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private TodoConverter converter;

    private Long id;
    private Long userId;
    private TodoResponse response;
    private TodoRequest request;
    private TodoDomain domain;

    private UserDomain userDomain;

    @BeforeEach
    public void init(){
        id = 1L;
        userId = 2L;
        response = TodoBuilder.validResponse();
        request = TodoBuilder.validRequest();
        domain = TodoBuilder.validCompleteDomain();
        userDomain = UserBuilder.validDomain();
    }
    @Test
    public void shouldGetById(){
        when(repository.findById(id)).thenReturn(Optional.of(domain));
        when(converter.domainToResponse(domain)).thenReturn(response);

        TodoResponse result = target.getById(id);

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

        List<TodoResponse> result = target.listAll();

        verify(repository).findAll();
        verify(converter).domainToResponse(domain);
        assertEquals(Collections.singletonList(response), result);
    }


    @Test
    public void shouldCreate(){
        when(userRepository.findById(userId)).thenReturn(Optional.of(userDomain));
        when(converter.requestToDomain(request)).thenReturn(domain);
        when(repository.save(domain)).thenReturn(domain);
        when(converter.domainToResponse(domain)).thenReturn(response);

        TodoResponse result = target.create(request);

        verify(userRepository).findById(userId);
        verify(converter).requestToDomain(request);
        verify(repository).save(domain);
        verify(converter).domainToResponse(domain);
        assertEquals(response, result);
    }


    @Test
    public void shouldCreateUserNotFound(){
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () ->  target.create(request));

        verify(userRepository).findById(userId);
        verify(converter, never()).requestToDomain(request);
    }

    @Test
    public void shouldUpdate(){
        when(userRepository.findById(userId)).thenReturn(Optional.of(userDomain));
        when(repository.findById(id)).thenReturn(Optional.of(domain));
        when(converter.requestToDomain(request)).thenReturn(domain);
        when(repository.save(domain)).thenReturn(domain);
        when(converter.domainToResponse(domain)).thenReturn(response);

        TodoResponse result = target.update(id, request);

        verify(userRepository).findById(userId);
        verify(repository).findById(id);
        verify(converter).requestToDomain(request);
        verify(repository).save(domain);
        verify(converter).domainToResponse(domain);
        assertEquals(response, result);
    }


    @Test
    public void shouldUpdateUserNotFound(){
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () ->  target.update(id, request));

        verify(userRepository).findById(userId);
        verify(repository, never()).findById(id);
    }

    @Test
    public void shouldUpdateNotFound(){
        when(userRepository.findById(userId)).thenReturn(Optional.of(userDomain));
        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () ->  target.update(id, request));

        verify(userRepository).findById(userId);
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
