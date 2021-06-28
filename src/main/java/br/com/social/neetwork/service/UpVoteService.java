package br.com.social.neetwork.service;

import br.com.social.neetwork.dto.UpvoteRequestDTO;

public interface UpVoteService {
	
	void saveUpvote(UpvoteRequestDTO request);

	void deleteUpvote(Long postId);

}
