package com.example.boardV1.board.api.request;

import com.example.boardV1.board.model.BoardCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardUpdateRequest {
    private String title;
    private String content;
    private BoardCategory category;
}
