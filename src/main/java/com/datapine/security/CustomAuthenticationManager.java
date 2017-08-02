package com.datapine.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationManager implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String username = authentication.getPrincipal() + "";
		String password = authentication.getCredentials() + "";

		// throw new BadCredentialsException("1000"); not found
		// throw new DisabledException("1001"); disabled
		// throw new BadCredentialsException("1000"); passw
		// List<Right> userRights = rightRepo.getUserRights(username);
		return new UsernamePasswordAuthenticationToken(username, password, null);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
