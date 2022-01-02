package com.smefinance.todoapp.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        for (int i = 1; i<=10; i++){
            String encPass = encoder.encode("123456");
            System.out.println(encPass);
        }
    }
}
