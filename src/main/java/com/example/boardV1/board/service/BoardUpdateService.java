package com.example.boardV1.board.service;

import com.example.boardV1.board.repository.BoardRepository;
import com.example.boardV1.user.service.UserFindService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BoardUpdateService {
    private final BoardFindService boardFindService;
    private final UserFindService userFindService;
}
