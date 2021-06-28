package br.com.social.neetwork.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpvoteRequestDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6155271779555792795L;
	
	@NotNull
	private Long postId;

}
