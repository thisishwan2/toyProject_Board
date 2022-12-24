package com.example.board.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class File {

    @Id @GeneratedValue
    @Column(name = "file_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    private String fileName;


}
