package com.example.boardV1.board.model;

import com.example.boardV1.comment.Model.Comment;
import com.example.boardV1.user.model.User;
import com.example.boardV1.util.TimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends TimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long board_id;

    @Column(name = "title")
    private String title;

    @Column(name = "board_content")
    @Lob
    private String content;

    @Column(name = "writer")
    private String writer;

    @Enumerated(EnumType.STRING)
    private BoardCategory category;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Board(String title, String content, String writer, BoardCategory category) {
        this.title=title;
        this.content=content;
        this.writer=writer;
        this.category=category;
    }

    public void createdByUser(User user) {
        this.user=user;
    }

    public void writeComment(Comment comment){
        this.comments.add(comment);
        comment.writtenBoard(this);
    }

    public Long update(String title, String content, BoardCategory category) {
        this.title = title;
        this.content = content;
        this.category = category;
        return this.getBoard_id();
    }
}
