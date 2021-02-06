package entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

@AllArgsConstructor
@NoArgsConstructor
public class Bot extends TelegramLongPollingBot {
    private static final Logger log = Logger.getLogger(Bot.class);
    final int RECONNECT_PAUSE =10000; ;
    Card card = new Card();
    // создаём  приватную глобальную переменную,  что-бы было проще брать id из чата
    private long chat_id;

    @Override
    public void onUpdateReceived(Update update) {
        //Обновить информацию о пользователе:
        update.getUpdateId();

      //SendMassage-класс для отправки сообщений  //setChatId - выставляет ИД человека который написал боту
      //update.getMessage().getChatId() - ИД того-же человека
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        chat_id = update.getMessage().getChatId();
        try {
            sendMessage.setText(input(update.getMessage().getText()));
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    @Override
    public String getBotUsername() {
        return "@OSONtestbot";
    }

    @Override
    public String getBotToken() {
        return "1381210707:AAH68fziyIQE91UlKRQC_I1ftdr-KXTfEoQ";
    }

    public String input(String msg) throws ProtocolException, MalformedURLException {
        if (msg.contains("Hi") || msg.contains("Hello") || msg.contains("Привет") || msg.contains("Как дела?")) {
            return "Здравствуйте, хотите совершить перевод? \n Введите номер карты";
        }
        if (msg.contains("3454646645564664") || msg.contains("68416719817981798") || msg.contains("684269898219889") || msg.contains("52987988798719")) {

            PostMethod post = new PostMethod("https://openapi-entry-api2.intervale.ru/api/v4/P2PCARD2CARDNET10BE51947C120CCD8/token");
            NameValuePair[] data = {
                    new NameValuePair("src.pan", "3454646645564664"),
                    new NameValuePair("dsc.pan", "bloggs")
            };
            post.setRequestBody(data);
            // execute method and handle any error responses.
            try {
                InputStream in = post.getResponseBodyAsStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
             // handle response.
            return "Ok";
        }
        return msg;
    }
    public void botConnect() {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(this);
            log.info("TelegramAPI started. Look for messages");
        } catch (TelegramApiRequestException e) {
            log.error("Cant Connect. Pause " + RECONNECT_PAUSE / 1000 + "sec and try again. Error: " + e.getMessage());
            try {
                Thread.sleep(RECONNECT_PAUSE);
            } catch (InterruptedException exp) {
                exp.printStackTrace();
                return;
            }
            botConnect();
        }
    }

}
