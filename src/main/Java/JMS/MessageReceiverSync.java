//package JMS;
//
//import javax.annotation.Resource;
//import javax.ejb.Stateless;
//import javax.jms.*;
//import java.util.Enumeration;
//
//@Stateless
//public class MessageReceiverSync {
//    @Resource(mappedName = "java:/ConnectionFactory")
//    private ConnectionFactory connectionFactory;
//
//    @Resource(mappedName = "java:/jms/queue/DLQ")
//    private Queue queue;
//
//
//    public String receiveMessage() {
//        try {
//            Connection connection = connectionFactory.createConnection();
//            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//            QueueBrowser queueBrowser = session.createBrowser(queue);
//            Enumeration enumeration = queueBrowser.getEnumeration();
//            while (enumeration.hasMoreElements()) {
//                TextMessage o = (TextMessage) enumeration.nextElement();
//                return "Receive:" + o.getText();
//            }
//            session.close();
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "";
//    }
//}
