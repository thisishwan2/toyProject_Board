package com.example.boardV1.board.api.request;

import com.example.boardV1.board.model.BoardCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardUpdateRequest {
    private String title;
    private String content;
    private BoardCategory category;
}
