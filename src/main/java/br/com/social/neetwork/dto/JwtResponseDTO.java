package br.com.social.neetwork.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponseDTO implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2852517418659397297L;
	
	private final String token;

}
