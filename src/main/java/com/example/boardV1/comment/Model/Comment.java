package com.example.boardV1.comment.Model;

import com.example.boardV1.board.model.Board;
import com.example.boardV1.user.model.User;
import com.example.boardV1.util.TimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends TimeEntity {

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long comment_id;

    @Column(name = "content")
    private String content;

    @Column(name = "writer")
    private String writer;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Comment(String content, String writer, Board board){
        this.writer=writer;
        this.content=content;
        this.board=board;
    }
    //댓글이 쓰여진 게시판 연관관계 메서드 생성될때 한번에
    public void writtenBoard(Board board){
        this.board=board;
    }

    public void writeByUser(User user) {
        this.user=user;
    }

    public Long update(String content) {
        this.content=content;
        return this.getComment_id();
    }
}
