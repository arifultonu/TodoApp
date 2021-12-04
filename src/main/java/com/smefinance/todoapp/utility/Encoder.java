package com.smefinance.todoapp.utility;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
public class Encoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        for (int i = 1; i<=10; i++){
            String encPass = encoder.encode("123456");
            log.info(encPass);
        }
    }
}
