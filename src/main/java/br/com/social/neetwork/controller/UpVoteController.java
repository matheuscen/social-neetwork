package br.com.social.neetwork.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.social.neetwork.dto.UpvoteRequestDTO;
import br.com.social.neetwork.service.UpVoteService;

@RestController
@RequestMapping("/upvote")
public class UpVoteController {
	
	@Autowired
	private UpVoteService upVoteService;
	
	@PostMapping
	public ResponseEntity<?> saveUpvote(@Valid @RequestBody UpvoteRequestDTO request) {
		
		this.upVoteService.saveUpvote(request);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteUpvote(@RequestParam(value="postId",required = true) Long postId) {
		
		this.upVoteService.deleteUpvote(postId);
		
		return ResponseEntity.noContent().build();
		
	}
	
	

}
