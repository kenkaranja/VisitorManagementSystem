//package JMS;
//
//import javax.annotation.Resource;
//import javax.ejb.Local;
//import javax.ejb.Stateless;
//import javax.jms.*;
//
//@Stateless
//public class MessageSender {
//    @Resource(mappedName = "java:/ConnectionFactory")
//    private ConnectionFactory connectionFactory;
//
//    @Resource(mappedName = "java:/jms/queue/DLQ")
//    private Queue queue;
//
//    public void sendMessage(String message) {
//        MessageProducer messageProducer;
//        TextMessage textMessage;
//        try {
//            Connection connection = connectionFactory.createConnection();
//            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//            messageProducer = session.createProducer(queue);
//            textMessage = session.createTextMessage();
//
//            textMessage.setText(message);
//            messageProducer.send(textMessage);
//            messageProducer.close();
//            session.close();
//            connection.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}
