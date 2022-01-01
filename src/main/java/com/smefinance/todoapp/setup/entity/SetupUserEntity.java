package com.smefinance.todoapp.setup.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class SetupUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String name;
    private String password;
    private String username;
    private String role;

    public SetupUserEntity(Long id, String password, String username, String role) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.role = role;
    }
}
