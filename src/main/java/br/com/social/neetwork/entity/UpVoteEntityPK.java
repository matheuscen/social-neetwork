package br.com.social.neetwork.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpVoteEntityPK implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 5359691232049750091L;

	@Column(name="username")
	private String username;
	
	@Column(name="post_id")
	private Long postId;

}
