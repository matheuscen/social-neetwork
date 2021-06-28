package br.com.social.neetwork.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequestDTO implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4989777155440917779L;
	private String username;
	private String password;
}
