package uk.co.simeonlees.poker.websockets;

/**
 * Created by simeonlees on 25/06/2017.
 */
public class OutboundMessage {

    private String sender;

    public OutboundMessage() {
    }

    public OutboundMessage(String sender) {
        this.sender = sender;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

}
