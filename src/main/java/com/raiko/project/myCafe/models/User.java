package com.raiko.project.myCafe.models;

import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private List<UserRole> userRoleList = new ArrayList<>();
    @Column(name = "login", unique = true)
    private String login;
    @Column(name = "password")
    private String password;

    //    private List<Contact> contactList = new ArrayList<>();
    @Column(name = "dateOfCreate")
    private LocalDate dateOfCreate;

    //    private avatar:
    @Type(type = "org.hibernate.type.TrueFalseType")
    @Column(name = "ban", columnDefinition = "CHAR(1)", length = 1)
    private Boolean ban;
    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "image")
    private String image;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Order> orderList = new ArrayList<>();

    public User(){}

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public User(Long id, String name, String surName, List<UserRole> userRoleList, String login, String password, LocalDate dateOfCreate, Boolean ban, LocalDate birthday, String image, List<Order> orderList) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.userRoleList = userRoleList;
        this.login = login;
        this.password = password;
        this.dateOfCreate = dateOfCreate;
        this.ban = ban;
        this.birthday = birthday;
        this.image = image;
        this.orderList = orderList;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.userRoleList;
    }

    @Override
    public String getUsername() {
        return login;
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

//    public boolean isUser() {
//        return getRoles().contains(UserRole.ROLE_USER);
//    }
//
//    public boolean isAdmin() {
//        return getRoles().contains(UserRole.ROLE_ADMIN);
//    }

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

}
