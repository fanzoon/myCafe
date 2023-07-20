package com.raiko.project.myCafe.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "role")
    private String role;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private User user;

    public UserRole(Long id, String role, User user) {
        this.id = id;
        this.role = role;
        this.user = user;
    }

    public UserRole() {

    }

    @Override
    public String getAuthority() {
        return this.role;
    }
}
