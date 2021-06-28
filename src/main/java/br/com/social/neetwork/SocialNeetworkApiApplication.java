package br.com.social.neetwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SocialNeetworkApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialNeetworkApiApplication.class, args);
	}

}
