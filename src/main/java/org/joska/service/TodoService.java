package org.joska.service;

import lombok.RequiredArgsConstructor;
import org.joska.mapper.TodoConverter;
import org.joska.model.todo.TodoDomain;
import org.joska.model.todo.TodoRequest;
import org.joska.model.todo.TodoResponse;
import org.joska.model.user.domain.UserDomain;
import org.joska.repository.TodoRepository;
import org.joska.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository repository;
    private final UserRepository userRepository;
    private final TodoConverter converter;

    public TodoResponse getById(Long id){
        TodoDomain domain = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        return converter.domainToResponse(domain);
    }

    public List<TodoResponse> listAll(){
        List<TodoDomain> domainList = repository.findAll();
        return domainList.stream().map(converter::domainToResponse).toList();
    }

    public TodoResponse create(TodoRequest request){
        UserDomain user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found!"));
        TodoDomain domain = converter.requestToDomain(request);
        domain.setUser(user);

        domain = repository.save(domain);

        return converter.domainToResponse(domain);
    }

    public TodoResponse update(Long id, TodoRequest request){
        UserDomain user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found!"));
        repository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        TodoDomain domain = converter.requestToDomain(request);
        domain.setUser(user);
        domain.setId(id);

        domain = repository.save(domain);

        return converter.domainToResponse(domain);
    }

    public void delete(Long id){
        repository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        repository.deleteById(id);
    }
}
