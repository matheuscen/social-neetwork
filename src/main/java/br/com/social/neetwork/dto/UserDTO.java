package br.com.social.neetwork.dto;

import java.io.Serializable;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -2844019390482010956L;

	@Size(min = 3, max = 50, message 
		      = "Usuário precisater ter no mínimo 3 carateres e no maximo 50")
	private String username;
	
	@Size(min = 4, max = 50, message 
		      = "Senha precisater ter no mínimo 4 carateres e no maximo 50")
	private String password; 
	
	@Size(min = 3, max = 70, message 
		      = "Nome Social precisater ter no mínimo 3 carateres e no maximo 70")
	private String socialName;

}
