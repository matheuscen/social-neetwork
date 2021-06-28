package br.com.social.neetwork.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="UPVOTE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpVoteEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1695206806002690006L;
	
	@Id
	@EmbeddedId
	private UpVoteEntityPK id;
	
	public UpVoteEntity(String username, Long postId) {
		UpVoteEntityPK pk = new UpVoteEntityPK();
		pk.setUsername(username);
		pk.setPostId(postId);
		id= pk;
	}

	
}
