package com.smefinance.todoapp.securityconfiguration.jwt;

import com.smefinance.todoapp.common.model.Parameters;
import com.smefinance.todoapp.login.repository.LoginRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class JwtInMemoryUserDetailsServiceImpl implements JwtInMemoryuserDetailsService {

    List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

    @Autowired
    private LoginRepository loginRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
				.filter(user -> user.getUsername().equals(username)).findFirst();
		if (!findFirst.isPresent()) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}
		return findFirst.get();
	}

	@Override
    public UserDetails loadUserByUsernamePassword(Parameters pv) throws UsernameNotFoundException {
		String pass = (String) loginRepository.findUserBySessionID(pv.getUserId());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encPass = encoder.encode(pass);
		Optional<JwtUserDetails> jwtUserDetails = Optional.of(new JwtUserDetails(1L, pv.getUserId(), encPass, "ROLE_USER_2"));
        if (!jwtUserDetails.isPresent()) {
            throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", pv.getUserId()));
        }
        inMemoryUserList = new ArrayList<>();
		inMemoryUserList.add(new JwtUserDetails(2L, pv.getUserId(), encPass, "ROLE_USER_2"));
		log.info("Memory Size :  " + inMemoryUserList.size());
        return jwtUserDetails.get();
    }

}
