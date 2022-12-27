package com.example.board.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id" )
    private Long Id;

    @NotNull
    private String title;

    private String content;

    @NotNull
    private LocalDateTime issuedDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "create_id")
    private Member member;

    @OneToMany(mappedBy = "board")
    private List<File> files = new ArrayList<>();

    @Builder
    public Board(String title, String content, Member member){
        this.title=title;
        this.content=content;
        this.member = member;
    }
}
