package br.com.social.neetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.social.neetwork.dto.UserDTO;
import br.com.social.neetwork.entity.UserEntity;
import br.com.social.neetwork.exceptions.UserAlreadyExistsException;
import br.com.social.neetwork.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void saveUser(UserDTO request) {
		
		UserEntity user = this.userRepository.findByUsernameOrSocialName(request.getUsername(),request.getSocialName());
		
		if(user == null) {
			user = UserEntity.builder()
					.password(passwordEncoder.encode(request.getPassword()))
					.username(request.getUsername())
					.socialName(request.getSocialName())
					.build();
			
			this.userRepository.save(user);
		} else {
			throw new UserAlreadyExistsException();
		}
		
	}

}
