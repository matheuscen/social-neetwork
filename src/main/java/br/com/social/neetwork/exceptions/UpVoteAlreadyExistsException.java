package br.com.social.neetwork.exceptions;

public class UpVoteAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3084070478998069049L;
	
	public UpVoteAlreadyExistsException() {
		super("Esse posts já tem o seu voto!");
	}

}
