package br.com.social.neetwork.dto;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.social.neetwork.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
	

	private Long id;
	
	@NotNull
	@Size(min = 3, max = 250)
	private String post;
	
	private String socialUserName;
	
	private Long upvotes;
	
	private Boolean yourVoted;
	
	public PostDTO(PostEntity p) {
		this.id = p.getId();
		this.post = p.getPost();
		
		
	}

	public PostDTO(Object[] p) {
		
		if(p[0] instanceof Integer) {
			this.id = ((Integer) p[0]).longValue();
		} else if(p[0] instanceof Long) {
			this.id = (Long) p[0];
		} else if(p[0] instanceof BigInteger) {
			this.id = ((BigInteger) p[0]).longValue();
		}
		
		this.post =  (String) p[1];
		this.socialUserName = (String) p[2];
		
		if(p[3] instanceof Integer) {
			this.upvotes = ((Integer) p[3]).longValue();
		} else if(p[3] instanceof Long) {
			this.upvotes = (Long) p[3];
		} else if(p[3] instanceof BigInteger) {
			this.upvotes = ((BigInteger) p[3]).longValue();
		}
		
		long upvoted = ((BigInteger) p[4]).longValue();
		
		if(upvoted > 0) {
			yourVoted = true;
		} else {
			yourVoted = false;
		}
	}
	
}
