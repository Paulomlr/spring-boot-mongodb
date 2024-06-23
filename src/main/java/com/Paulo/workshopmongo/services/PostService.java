package com.Paulo.workshopmongo.services;

import com.Paulo.workshopmongo.domain.Post;
import com.Paulo.workshopmongo.repository.PostRepository;
import com.Paulo.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }

    public List<Post> finfByTitle(String text){
        return repository.findByTitleContainingIgnoreCase(text);
    }
}
