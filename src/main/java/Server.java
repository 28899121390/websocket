import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by hetengfei on 2018/1/18.
 */
@ServerEndpoint("/hello")
public class Server {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("client come.....");
        try {
            session.getBasicRemote().sendText("hello i am client");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @OnMessage
    public void onMessage(Session session, String msg) {
        try {
            session.getBasicRemote().sendText("hello i am server msg is "+msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @OnClose
    public void onClose(Session session) {
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
