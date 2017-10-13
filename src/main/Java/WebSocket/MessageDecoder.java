package WebSocket;

import com.google.gson.Gson;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class MessageDecoder implements Decoder.Text<Message> {
    public Message decode(String s) throws DecodeException {
        Gson gson = new Gson();
        return gson.fromJson(s, Message.class);
    }

    public boolean willDecode(String s) {
        return s != null;
    }

    public void init(EndpointConfig endpointConfig) {

    }

    public void destroy() {

    }
}
