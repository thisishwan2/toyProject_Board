package com.example.boardV1.notification;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
@Slf4j
public class FirebaseCloudMessageService {
    public void sendMessageTo(String targetToken, String title, String body) throws FirebaseMessagingException, IOException, ExecutionException, InterruptedException {
////FirebaseMessaging 사용
//        Message message = makeMessage(targetToken, title, body);
//        String response = FirebaseMessaging.getInstance().send(message);
//        log.info(response);
//
//        //비동기
//        String asyncMessage = FirebaseMessaging.getInstance().sendAsync(message).get();
    }
}
