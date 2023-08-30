package com.gabrielbrito.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielbrito.workshopmongo.domain.Post;
import com.gabrielbrito.workshopmongo.repositories.PostRepository;
import com.gabrielbrito.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not founded"));
	}
	
	public List<Post> findByTitle(String text){
		return repository.searchTitle(text);
	}
}
