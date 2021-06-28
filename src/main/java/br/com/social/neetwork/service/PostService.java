package br.com.social.neetwork.service;

import org.springframework.data.domain.Pageable;

import br.com.social.neetwork.dto.FindAllPostsResponseDTO;
import br.com.social.neetwork.dto.PostDTO;

public interface PostService {
	
	
	public FindAllPostsResponseDTO findAllPosts(Pageable page);
	
	public void savePost(PostDTO request);
	
	
}
