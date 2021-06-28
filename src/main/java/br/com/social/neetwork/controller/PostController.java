package br.com.social.neetwork.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.social.neetwork.dto.FindAllPostsResponseDTO;
import br.com.social.neetwork.dto.PostDTO;
import br.com.social.neetwork.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	
	@GetMapping
	public ResponseEntity<FindAllPostsResponseDTO> findAllPosts( @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "10") int size) {
	
		Pageable pageable = PageRequest.of(page, size);
		
		FindAllPostsResponseDTO response = this.postService.findAllPosts(pageable);
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<?> savePost(@Valid @RequestBody PostDTO request) {
		
		this.postService.savePost(request);
		
		return ResponseEntity.created(URI.create("")).build();
	}

}
