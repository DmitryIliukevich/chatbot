package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
@Component
public class TelegramBot extends TelegramLongPollingBot {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TelegramBot.class);

    @Autowired
    private CityService service;

    /**
     * Метод для настройки сообщения и его отправки.
     * @param chatId id чата
     * @param s Строка, которую необходимот отправить в качестве сообщения.
     */
    public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
           log.error("TelegramApiException: ", e);
        }
    }



    @Override
    public void onUpdateReceived(Update update) {
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        Update update = updates.get(0);
        String message = update.getMessage().getText();
        String brand = service.findBrand(message);
        if (brand != null) {
            sendMsg(update.getMessage().getChatId().toString(), brand);
        } else {
            sendMsg(update.getMessage().getChatId().toString(), "Нет такого города!");
        }
    }

    @Override
    public String getBotUsername() {
        return "DimaTouristBot";
    }

    @Override
    public String getBotToken() {
        return "1096493355:AAH5BzkCyVgZUPAD-EoK7qdvvY4W0oLtcsA";
    }

}
