package org.joska.service;

import lombok.RequiredArgsConstructor;
import org.joska.mapper.CommentConverter;
import org.joska.model.comment.CommentDomain;
import org.joska.model.comment.CommentRequest;
import org.joska.model.comment.CommentResponse;
import org.joska.model.post.PostDomain;
import org.joska.model.user.domain.UserDomain;
import org.joska.repository.CommentRepository;
import org.joska.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository repository;
    private final PostRepository postRepository;
    private final CommentConverter converter;

    public CommentResponse getById(Long id){
        CommentDomain domain = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        return converter.domainToResponse(domain);
    }

    public List<CommentResponse> listAll(){
        List<CommentDomain> domainList = repository.findAll();
        return domainList.stream().map(converter::domainToResponse).toList();
    }

    public CommentResponse create(CommentRequest request){
        PostDomain post = postRepository.findById(request.getPostId())
                .orElseThrow(() -> new RuntimeException("User not found!"));
        CommentDomain domain = converter.requestToDomain(request);
        domain.setPost(post);

        domain = repository.save(domain);

        return converter.domainToResponse(domain);
    }

    public CommentResponse update(Long id, CommentRequest request){
        PostDomain post = postRepository.findById(request.getPostId())
                .orElseThrow(() -> new RuntimeException("User not found!"));
        repository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
        CommentDomain domain = converter.requestToDomain(request);
        domain.setPost(post);
        domain.setId(id);

        domain = repository.save(domain);

        return converter.domainToResponse(domain);
    }

    public void delete(Long id){
        repository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
        repository.deleteById(id);
    }
}
