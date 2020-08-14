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
        if (updates != null && !updates.isEmpty()) {
            Update update = updates.get(0);
            String message = update.getMessage().getText();
            if (!message.contains("start")) {
                String brand = service.findBrand(message);
                if (brand != null) {
                    sendMsg(update.getMessage().getChatId().toString(), brand);
                } else {
                    sendMsg(update.getMessage().getChatId().toString(), "Информации по этому городу нет!");
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "SimpleTouristChatBot";
    }

    @Override
    public String getBotToken() {
        return "1139858792:AAFDt1hDGncht74FS2sltjCNFbGh2Qxp7qQ";
    }

}
