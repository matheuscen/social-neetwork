package br.com.social.neetwork.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.social.neetwork.dto.UpvoteRequestDTO;
import br.com.social.neetwork.entity.UpVoteEntity;
import br.com.social.neetwork.entity.UpVoteEntityPK;
import br.com.social.neetwork.exceptions.PostNotFoundException;
import br.com.social.neetwork.exceptions.UpVoteAlreadyExistsException;
import br.com.social.neetwork.repository.PostRepository;
import br.com.social.neetwork.repository.UpVoteRepository;
import br.com.social.neetwork.util.JwtTokenUtil;

@Service
public class UpVoteServiceImpl implements UpVoteService {
	
	@Autowired
	private UpVoteRepository upVoteRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private HttpServletRequest requestServlet;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	public void saveUpvote(UpvoteRequestDTO request) {
		
		String username = jwtTokenUtil.getUsernameFromToken((String) requestServlet.getAttribute("token"));
		
		this.postRepository.findById(request.getPostId()).orElseThrow(() -> new PostNotFoundException());
		
		UpVoteEntity upVoteEntity = new UpVoteEntity(username, request.getPostId());
		
		this.upVoteRepository.findById(upVoteEntity.getId()).ifPresent(upVote -> {throw new UpVoteAlreadyExistsException();});
		
		this.upVoteRepository.save(upVoteEntity);
		
	}

	@Override
	public void deleteUpvote(Long postId) {
		
		String username = jwtTokenUtil.getUsernameFromToken((String) requestServlet.getAttribute("token"));
		
		UpVoteEntityPK pk = new UpVoteEntityPK();
		pk.setPostId(postId);
		pk.setUsername(username);
		
		UpVoteEntity upVoteEntity = this.upVoteRepository.findById(pk).orElseThrow(() ->  new UpVoteAlreadyExistsException());
		
		this.upVoteRepository.delete(upVoteEntity);
		
	}

}
