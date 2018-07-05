package de.itemis.auth.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import de.itemis.auth.domain.UserDetails;

public class AuthTokenEnhancer implements TokenEnhancer {
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		UserDetails user = (UserDetails) authentication.getPrincipal();

		if (user != null) {
			final Map<String, Object> additionalInfo = new HashMap<>();
			additionalInfo.put("userId", user.getUserId());
			((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
		}
		
		return accessToken;
	}
}