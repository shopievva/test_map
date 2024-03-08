package com.example.test_map.config;
import org.slf4j.Logger;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.slf4j.LoggerFactory;



public class CoordinatesWebSocketHandler extends TextWebSocketHandler {
    private static final String FILE_NAME = "src/main/resources/coordinates.txt";
    private static final Logger logger = LoggerFactory.getLogger(CoordinatesWebSocketHandler.class);



    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        String payload = message.getPayload();
        System.out.println("Получены координаты: " + payload);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(payload);
            writer.newLine();
        } catch (IOException e) {
            logger.error("Ошибка при обработке сообщения", e);
        }
    }
}