package WebSocket;

import com.google.gson.Gson;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.*;

import static java.lang.String.format;

@javax.websocket.server.ServerEndpoint(value = "/chat/{username}", decoders = MessageDecoder.class)
public class ServerEndpoint {
    static Map<String, Session> peers = new HashMap<String, Session>();

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String s) {
        peers.put(s, session);
        getNumberOfConnection();
    }

    @OnMessage
    public void onMessage(Message message, Session session) {

        try {
            peers.get(message.getReceiver()).getBasicRemote().sendObject(message.getContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session) {
        try {
            System.out.println("left the chat room.");
            peers.remove(session.getId());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getNumberOfConnection() {
        for (Map.Entry m : peers.entrySet()) {
            Session s = (Session) m.getValue();
            System.out.println(m.getKey() + " " + s.getId());
        }
    }
}
