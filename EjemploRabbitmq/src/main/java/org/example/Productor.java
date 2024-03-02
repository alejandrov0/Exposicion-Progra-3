package org.example;
import com.rabbitmq.client.*;

public class Productor {

    private final static String COLA_NOMBRE = "mi_cola";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");z

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(COLA_NOMBRE, false, false, false, null);
            String mensaje = "Hola, RabbitMQ!";
            channel.basicPublish("", COLA_NOMBRE, null, mensaje.getBytes());
            System.out.println(" [x] Enviado '" + mensaje + "'");
        }
    }
}