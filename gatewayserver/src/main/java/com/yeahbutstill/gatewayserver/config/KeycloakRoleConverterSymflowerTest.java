package com.yeahbutstill.gatewayserver.config;

import java.util.Collection;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

public class KeycloakRoleConverterSymflowerTest {
	@Test
	public void convert1() {
		KeycloakRoleConverter k = null; // TODO This is a fallback value due to incomplete analysis.
		Jwt jwt = null; // TODO This is a fallback value due to incomplete analysis.
		Collection<GrantedAuthority> expected = null; // TODO This is a fallback value due to incomplete analysis.
		Collection<GrantedAuthority> actual = k.convert(jwt);

		assertEquals(expected, actual);
	}
}
