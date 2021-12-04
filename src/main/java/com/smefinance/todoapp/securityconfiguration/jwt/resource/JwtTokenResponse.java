package com.smefinance.todoapp.securityconfiguration.jwt.resource;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenResponse implements Serializable {

	private static final long serialVersionUID = 8317676219297719109L;

	private final String token;
	private Map<String, Object> map = new HashMap<>();

	public JwtTokenResponse(String token, Map<String, Object> map) {
		this.token = token;
		this.map = map;
	}

	public String getToken() {
		return this.token;
	}
	public Map<String, Object> getMap(){ return this.map;}
}