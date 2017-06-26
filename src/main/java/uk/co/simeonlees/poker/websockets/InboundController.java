package uk.co.simeonlees.poker.websockets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import uk.co.simeonlees.poker.controllers.ChatboxController;
import uk.co.simeonlees.poker.websockets.messages.BaseMessage;
import uk.co.simeonlees.poker.websockets.messages.ChatMessage;

import java.security.Principal;

/**
 * Created by simeonlees on 25/06/2017.
 */

@Controller
public class InboundController {

    @Autowired private OutboundController outboundController;
    @Autowired private ChatboxController chatboxController;


    @MessageMapping("/in")
    public void processMessage(Principal principal, Message<Object> message, @Payload BaseMessage baseMessage) throws Exception {
        System.out.println("<><><> RECEIVED MESSAGE");


        if (baseMessage.getMessageType() == BaseMessage.MessageType.CHAT) {
//            System.out.println("chatta chatta");
            chatboxController.processMessage(baseMessage.getChatMessage());
        }

//        Principal principal = message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class);
        String authedSender = principal.getName();
        System.out.println(authedSender);
    }

}
