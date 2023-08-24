package com.raiko.project.myCafe.dtos;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

public class UserDTO {
    private Long id;

    @NotEmpty(message = "Поле имя не должно быть пустым")
    @Pattern(regexp = "[А-Я][а-я]*", message = "Имя должно начитаться с заглавной буквы")
    @Size(min = 2, max = 20)
    private String name;

    @NotEmpty(message = "Поле фамилия не должно быть пустым")
    @Pattern(regexp = "[А-Я][а-я]*", message = "Фамилия должна начитаться с заглавной буквы")
    @Size(min = 2, max = 20, message = "Количество символов должно быть от 2 до 20 включительно")
    private String surName;

    @NotEmpty(message = "Поле имя не должно быть пустым")
    @Size(min = 5, max = 20, message = "Количество символов должно быть от 5 до 20 включительно")
    private String login;

    @NotEmpty(message = "Поле password не должно быть пустым")
    @Size(min = 5, max = 20, message = "Количество символов должно быть от 5 до 20 включительно")
    private String password;

    @NotEmpty(message = "Поле confirmPassword не должно быть пустым")
    @Size(min = 5, max = 20, message = "Количество символов должно быть от 5 до 20 включительно")
    private String confirmPassword;

    private LocalDate birthday;

    public UserDTO() {
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
