package com.example.board.entity;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;


import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue
    @Column(name = "create_id")
    private Long id;

    @Column(length = 40)
    @NotNull
    private String memberId;

    @Column(length = 20)
    @NotNull
    private String password;

    @Column(length = 20)
    @NotNull
    private String name;

    @Builder
    public Member(String name, String password, String memberId){
        Assert.hasText(memberId, "memberId must not be empty");
        Assert.hasText(name, "name must not be empty");
        Assert.hasText(password, "password must not be empty");


        this.memberId=memberId;
        this.name=name;
        this.password=password;
    }

}
