package de.itemis.auth.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import de.itemis.auth.domain.User;
import de.itemis.auth.domain.UserDetails;

@Component
public class UserDetailsConverter implements Converter<de.itemis.auth.domain.User, UserDetails> {
	@Override
	public UserDetails convert(User user) {
		UserDetails userDetails = new UserDetails();

		if (user != null) {
			userDetails.setUserId(user.getId());
			userDetails.setUsername(user.getUsername());
			userDetails.setPassword(user.getPasswordHash());
			userDetails.setEnabled(user.isEnabled());
			userDetails.setAccountExpired(true);
			userDetails.setAccountLocked(true);
			userDetails.setCredentialsExpired(true);
		}

		return userDetails;
	}
}
