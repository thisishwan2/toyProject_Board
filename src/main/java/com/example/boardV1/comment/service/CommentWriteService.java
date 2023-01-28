package com.example.boardV1.comment.service;

import com.example.boardV1.board.model.Board;
import com.example.boardV1.board.service.BoardFindService;
import com.example.boardV1.comment.Model.Comment;
import com.example.boardV1.comment.api.request.CommentWriteRequest;
import com.example.boardV1.comment.repository.CommentReposiroty;
import com.example.boardV1.notification.FirebaseCloudMessageService;
import com.example.boardV1.user.model.User;
import com.example.boardV1.user.service.UserFindService;
import com.google.firebase.messaging.FirebaseMessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentWriteService {

    private final UserFindService userFindService;
    private final BoardFindService boardFindService;
    private final CommentReposiroty commentReposiroty;
//    private final FirebaseCloudMessageService messageService;

    @Transactional
    public Long writeComment(Long userId, Long boardId, CommentWriteRequest commentWriteRequest) throws IOException, ExecutionException, FirebaseMessagingException, InterruptedException {
        Board board = boardFindService.findById(boardId);
        User user = userFindService.findById(userId);

        Comment comment = Comment.builder()
                .content(commentWriteRequest.getContent())
                .writer(user.getName())
                .board(board)
                .build();
        Comment savedComment = commentReposiroty.save(comment);
        user.writeComment(savedComment);
        board.writeComment(savedComment);

//        String targetToken = board.getUser().getDeviceToken();
//        sendMessageToBoardWriter(targetToken, "Comment Notification!", comment.getWriter(), comment.getContent());
        return savedComment.getComment_id();
    }

//    private void sendMessageToBoardWriter(String targetToken, String title, String writer,String content) throws FirebaseMessagingException,
//            IOException, ExecutionException, InterruptedException {
//        messageService.sendMessageTo(targetToken, title, "[" + writer + "]" + "가 댓글 : <" + content + ">을 작성했습니다.");
//
//    }
}
