package de.itemis.auth.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Encoders {
	@Bean
	@Qualifier("passwordEncoder")
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(4);
	}

	@Bean
	@Primary
	@Qualifier("oauthClientPasswordEncoder")
	public PasswordEncoder oauthClientPasswordEncoder() {
		return new BCryptPasswordEncoder(4) {
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return passwordEncoder().matches(rawPassword, encodedPassword);
			}
		};
	}

	@Bean
	@Qualifier("userPasswordEncoder")
	public PasswordEncoder userPasswordEncoder() {
		return new BCryptPasswordEncoder(8) {
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return passwordEncoder().matches(rawPassword, encodedPassword);
			}
		};
	}
}
