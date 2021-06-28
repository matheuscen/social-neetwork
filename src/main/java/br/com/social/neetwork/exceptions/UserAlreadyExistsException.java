package br.com.social.neetwork.exceptions;

public class UserAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6832512384245550822L;
	
	public UserAlreadyExistsException() {
		super("Usúario já existe.");
	}

}
