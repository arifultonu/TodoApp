package com.smefinance.todoapp.securityconfiguration.jwt;

import com.smefinance.todoapp.common.model.CommonListValue;
import com.smefinance.todoapp.setup.entity.SetupUserEntity;
import com.smefinance.todoapp.setup.repository.SetupUserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

	static {
		inMemoryUserList.add(new JwtUserDetails(1L, "Ariful",
				"$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
		inMemoryUserList.add(new JwtUserDetails(2L, "Tonu",
				"$2a$10$gfIuJbYdvTQzbS.KxEP3VOhtlOL8tGbcGdiNgAZ9wK.RyHKg2vKLe", "ROLE_USER_2"));

		log.info("Login Called!!");

		//$2a$10$IetbreuU5KihCkDB6/r1DOJO0VyU9lSiBcrMDT.biU7FOt2oqZDPm
	}

//	@Autowired
//	SetupUserRepo setupUserRepo;

//
//	@Override
//	public List<SetupUserEntity> getAllUserList() {
//		return setupUserRepo.findAll();
//
//	}

//	@Override
//	public List<SetupUserEntity> getAllUserDataListRepo() {
//		List<Object[]> list = setupUserRepo.getAllUserList();
//		List<SetupUserEntity> inMemoryUserList = new ArrayList<>();
//		list.stream().forEach(arr -> {
//			SetupUserEntity obj = new SetupUserEntity();
//			obj.setId((Number)(arr[0]);
//			obj.setUsername((String) arr[1]);
//			obj.setPassword((String) arr[2]);
//			obj.setRole((String) arr[3]);
//			inMemoryUserList.add(obj);
//		});
//		return inMemoryUserList;
//	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
				.filter(user -> user.getUsername().equals(username)).findFirst();

		if (!findFirst.isPresent()) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}
		return findFirst.get();
	}

	}
