package com.example.boardV1.board.api;

import com.example.boardV1.board.service.BoardDeleteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/boards/delete")
@RequiredArgsConstructor
public class BoardDeleteApi {
    private final BoardDeleteService boardDeleteService;

    @DeleteMapping("/{userId}/{boardId}")
    public void deleteBoardById(@PathVariable Long userId, @PathVariable Long boardId){
        boardDeleteService.deleteBoard(userId, boardId);
    }
}
