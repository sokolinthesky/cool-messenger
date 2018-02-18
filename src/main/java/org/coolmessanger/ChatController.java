package org.coolmessanger;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/hello")
    @SendTo("/topic/cool-chat")
    public Message greeting(Message message) {
        return new Message("Broker", "Hello, " + message.getUserName() + "!");
    }

    @MessageMapping("/send")
    @SendTo("/topic/cool-chat")
    public Message sendMessage(Message message) {
        return message;
    }
}
