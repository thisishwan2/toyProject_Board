package com.example.boardV1.comment.repository;

import com.example.boardV1.board.model.Board;
import com.example.boardV1.comment.Model.Comment;
import com.example.boardV1.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentReposiroty extends JpaRepository<Comment, Long> {
    List<Comment> findCommentByBoard(Board board);
    Optional<Comment> findByUserAndBoard(User user, Board board);
}
