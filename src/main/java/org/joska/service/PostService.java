package org.joska.service;

import lombok.RequiredArgsConstructor;
import org.joska.mapper.PostConverter;
import org.joska.model.post.PostDomain;
import org.joska.model.post.PostRequest;
import org.joska.model.post.PostResponse;
import org.joska.model.user.domain.UserDomain;
import org.joska.repository.UserRepository;
import org.joska.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repository;
    private final PostConverter converter;
    private final UserRepository userRepository;

    public PostResponse getById(Long id){
        PostDomain domain = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        return converter.domainToResponse(domain);
    }

    public List<PostResponse> listAll(){
        List<PostDomain> domainList = repository.findAll();
        return domainList.stream().map(converter::domainToResponse).toList();
    }

    public PostResponse create(PostRequest request){
        UserDomain user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found!"));
        PostDomain domain = converter.requestToDomain(request);
        domain.setUser(user);

        domain = repository.save(domain);

        return converter.domainToResponse(domain);
    }

    public PostResponse update(Long id, PostRequest request){
        UserDomain user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found!"));
        PostDomain oldDomain = repository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        PostDomain domain = converter.requestToDomain(request);
        domain.setUser(user);
        domain.setId(id);

        domain.setComments(oldDomain.getComments());

        domain = repository.save(domain);

        return converter.domainToResponse(domain);
    }

    public void delete(Long id){
        repository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        repository.deleteById(id);
    }
}
