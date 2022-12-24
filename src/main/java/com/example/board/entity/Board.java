package com.example.board.entity;


import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Entity
@Getter
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id" )
    private Long Id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private LocalDateTime issuedDate;

    @ManyToOne
    @JoinColumn(name = "create_id")
    private Member member;


}
