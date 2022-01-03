package com.smefinance.todoapp.securityconfiguration.jwt.resource;

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtTokenResponse implements Serializable {

	private static final long serialVersionUID = 8317676219297719109L;

	private final Long id;
	private final String name;
	private final String role;
	private final String token;

	public JwtTokenResponse(Long id, String name, String role, String token) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.token = token;

	}

}