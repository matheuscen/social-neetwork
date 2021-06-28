package br.com.social.neetwork.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.social.neetwork.dto.FindAllPostsResponseDTO;
import br.com.social.neetwork.dto.PostDTO;
import br.com.social.neetwork.entity.PostEntity;
import br.com.social.neetwork.entity.UserEntity;
import br.com.social.neetwork.repository.PostRepository;
import br.com.social.neetwork.repository.UserRepository;
import br.com.social.neetwork.util.JwtTokenUtil;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private HttpServletRequest requestServlet;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	public FindAllPostsResponseDTO findAllPosts(Pageable page) {
		
		String username = jwtTokenUtil.getUsernameFromToken((String) requestServlet.getAttribute("token"));
		
		FindAllPostsResponseDTO response = new FindAllPostsResponseDTO();
		
		Page<Object[]> posts = this.postRepository.findAllPageable(page, username);
		
		response.setTotalPages(posts.getTotalPages());
		
		response.setTotalElements(posts.getTotalElements());
		
		List<PostDTO> postsDTO = posts.getContent().stream().map(
		        p -> new PostDTO(p)
		).collect(Collectors.toList());
	
		response.setPosts(postsDTO);
		
		
		return response;
		
	}

	@Override
	public void savePost(PostDTO request) {
		
		String username = jwtTokenUtil.getUsernameFromToken((String) requestServlet.getAttribute("token"));
		
		UserEntity user = this.userRepository.findByUsername(username);
		
		PostEntity post = new PostEntity();
		
		post.setPost(request.getPost());
		
		post.setUserId(user.getId());
		
		post.setDate(new Date());
		
		this.postRepository.save(post);
		
	}

}
