package br.com.social.neetwork.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindAllPostsResponseDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1273503125797830264L;

	private int totalPages;
	
	private long totalElements;
	
	private List<PostDTO> posts;

}
