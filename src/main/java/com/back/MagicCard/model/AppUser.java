package com.back.MagicCard.model;

import jakarta.persistence.*;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String name;
    private String username;
    @Column(name="email_adress", unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UsersRole usersRole;

    public AppUser(){

    }
    public AppUser(Long user_id, String name, String username, String email, String password, UsersRole usersRole) {
        this.user_id = user_id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.usersRole = usersRole;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsersRole getUsersRole() {
        return usersRole;
    }

    public void setUsersRole(UsersRole usersRole) {
        this.usersRole = usersRole;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", usersRole=" + usersRole +
                '}';
    }
}
