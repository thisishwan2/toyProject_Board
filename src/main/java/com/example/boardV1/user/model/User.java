package com.example.boardV1.user.model;

import com.example.boardV1.board.model.Board;
import com.example.boardV1.comment.Model.Comment;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Board> boards = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    List<Comment> comments = new ArrayList<>();

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

    public void writeBoard(Board board) {
        this.boards.add(board);
        board.createdByUser(this);
    }

    public void writeComment(Comment comment){
        this.comments.add(comment);
        comment.writeByUser(this);
    }
}
