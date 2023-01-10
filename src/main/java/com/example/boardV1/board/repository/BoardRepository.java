package com.example.boardV1.board.repository;

import com.example.boardV1.board.model.Board;
import com.example.boardV1.board.model.BoardCategory;
import com.example.boardV1.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByCategory(BoardCategory category);
    List<Board> findByUser(User user);
}
