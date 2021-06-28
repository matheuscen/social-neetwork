package br.com.social.neetwork.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "POST")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8932759246859016206L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String post;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
}
