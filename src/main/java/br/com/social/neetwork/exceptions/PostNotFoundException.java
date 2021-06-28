package br.com.social.neetwork.exceptions;

public class PostNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7033713058340404689L;

	public PostNotFoundException() {
		super("Post não existe!");
	}
}
