package br.com.social.neetwork.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.social.neetwork.entity.UserEntity;
import br.com.social.neetwork.exceptions.UserAlreadyExistsException;
import br.com.social.neetwork.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@SuppressWarnings("serial")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserEntity ent = this.userRepository.findByUsername(username);

		UserDetails user = null;

		if (ent != null) {

			Collection<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();

			roles.add(new GrantedAuthority() {

				@Override
				public String getAuthority() {
					return "USER";
				}
			});

			user = new User(ent.getUsername(), ent.getPassword(), roles);
		} else {
			throw new UserAlreadyExistsException();
		}

		return user;
	}

}
