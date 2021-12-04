package com.smefinance.todoapp.securityconfiguration.jwt;

import com.smefinance.todoapp.common.model.Parameters;
import org.springframework.security.core.userdetails.UserDetailsService;

interface JwtInMemoryuserDetailsService extends UserDetailsService {

    org.springframework.security.core.userdetails.UserDetails loadUserByUsernamePassword(Parameters pv) throws org.springframework.security.core.userdetails.UsernameNotFoundException;

}
