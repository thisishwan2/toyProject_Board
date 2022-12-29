package com.example.boardV1.user.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "device_token")
    private String deviceToken;

    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    @Builder
    public User(String email, String password, String name, UserRole userRole){
        this.email = email;
        this.password = password;
        this.name = name;
        this.userRole = userRole;
    }

    public User updateUserInfo(String name, String password) {
        this.name=name;
        this.password=password;
        return this;
    }

    public void modifyDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
}
