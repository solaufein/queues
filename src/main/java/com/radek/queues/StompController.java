package com.radek.queues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class StompController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    /**
     * QUEUE TO-ACTIVE-USER-SESSIONS:
     * This will send message only to specific user (subscribed to '/user/queue/chat').
     * It will send message to all user sessions.
     * It will resolve user based on Spring Security mechanisms.
     * If there is no active user subscription, message will be lost!
     */
    @GetMapping("/chat/send1")
    public ResponseEntity<String> send1() {
        String message = "message: " + UUID.randomUUID().toString();
        String user = "111";
        String destination = "/queue/chat";

        simpMessagingTemplate.convertAndSendToUser(user, destination, message);

        return ResponseEntity.ok("send1 - " + destination);
    }

    /**
     * QUEUE ONE-TO-ONE:
     * This will send message to queue (subscribed to '/queue/chat-111').
     * Message will be delivered to only one subscriber (Load balanced).
     * If no subscribers, messages will be enqueued and delivered later on any subscription (Timeout may be set).
     */
    @GetMapping("/chat/send2")
    public ResponseEntity<String> send2() {
        String message = "message: " + UUID.randomUUID().toString();
        String user = "111";
        String destination = "/queue/chat-" + user;

        simpMessagingTemplate.convertAndSend(destination, message);

        return ResponseEntity.ok("send2 - " + destination);
    }

    /**
     * TOPIC BROADCAST:
     * This will send message to topic (subscribed to '/topic/hello').
     * Message will be delivered to all active subscribers (Load balanced).
     * If there is no active user subscription, message will be lost!
     */
    @GetMapping("/chat/send3")
    public ResponseEntity<String> send3() {
        String message = "message: " + UUID.randomUUID().toString();
        String user = "111";
        String destination = "/topic/hello";

        simpMessagingTemplate.convertAndSend(destination, message);

        return ResponseEntity.ok("send3 - " + destination);
    }

    /**
     * DURABLE TOPIC SUBSCRIPTION:
     * This will send message to topic (subscribed to '/topic/hello-111').
     * Message will be delivered to all active subscribers (Load balanced).
     * If no subscribers, messages will be enqueued and delivered later on any subscription (Timeout may be set).
     */
    @GetMapping("/chat/send4")
    public ResponseEntity<String> send4() {
        String message = "message: " + UUID.randomUUID().toString();
        String user = "111";
        String destination = "/topic/hello-" + user;

        simpMessagingTemplate.convertAndSend(destination, message);

        return ResponseEntity.ok("send4 - " + destination);
    }

}
