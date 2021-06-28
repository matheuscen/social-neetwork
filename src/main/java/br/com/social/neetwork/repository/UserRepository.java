package br.com.social.neetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.social.neetwork.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	public UserEntity findByUsername(String username);
	
	public UserEntity findByUsernameOrSocialName(String username, String socialName);

}
