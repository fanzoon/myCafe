package com.raiko.project.myCafe.models;

import com.raiko.project.myCafe.enums.Gender;
import com.raiko.project.myCafe.enums.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")

public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surName")
    private String surName;
    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles = new HashSet<>();
    @Column(name = "nickName", unique = true)
    private String nickName;
    @Column(name = "password")
    private String password;

    //    private List<Contact> contactList = new ArrayList<>();
    @Column(name = "dateOfCreate")
    private LocalDate dateOfCreate;

    //    private avatar:
    @Column(name = "ban")
    private Boolean ban;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public User(){}

    public User(Long id, String name, String surName, Set<UserRole> roles, String nickName, String password,
                LocalDate dateOfCreate, Boolean ban, LocalDate birthday, Gender gender) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.roles = roles;
        this.nickName = nickName;
        this.password = password;
        this.dateOfCreate = dateOfCreate;
        this.ban = ban;
        this.birthday = birthday;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return nickName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !ban;
    }

    public boolean isUser() {
        return getRoles().contains(UserRole.USER_ROLE);
    }

    public boolean isAdmin() {
        return getRoles().contains(UserRole.ADMIN_ROLE);
    }

//    public boolean isUnregisteredRole() {
//        return getRoles().contains(UserRole.UNREGISTERED_ROLE);
//    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(LocalDate dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public Boolean getBan() {
        return ban;
    }

    public void setBan(Boolean ban) {
        this.ban = ban;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
