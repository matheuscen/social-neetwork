package br.com.social.neetwork.exceptions;

public class UpVoteNotFoundExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3084070478998069049L;
	
	public UpVoteNotFoundExistsException() {
		super("Não existe voto para esse post com este usuário!");
	}

}
