import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;

public class Transfer {


}
/*
public class Book  extends TelegramLongPollingBot {
    /* Создаём объект карточки
   // Book book = new Book();

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

        sendMessage.setText(input(update.getMessage().getText()));
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

    public String input(String msg){
        if (msg.contains("Hi") || msg.contains("Hello") || msg.contains("Привет")) {
            return "Здравствуйте, хотите совершить перевод?";
        }
        if(msg.contains("Информация о карточке")){
            return getInfoBook();
        }
        return msg;
    }

    public String getInfoBook(){
        try {
            URL url = new URL(card.getImage());
            // берем сслыку на изображение
            BufferedImage img = ImageIO.read(url);
            // качаем изображение в буфер
            File outputfile = new File("image.jpg");
            //создаем новый файл в который поместим
            //скаченое изображение
            ImageIO.write(img, "jpg", outputfile);
            //преобразовуем наше буферное изображение
            //в новый файл
            SendPhoto sendPhoto = new SendPhoto().setChatId(chat_id);
            sendPhoto.setPhoto(outputfile);
            execute(sendPhoto);
        } catch (Exception e){
            System.out.println("File not found");
            e.printStackTrace();
        }

        String info = book.getTitle()
                + "\nАвтор" + book.getAutorName()
                + "\nЖанр" + book.getGenres()
                + "\n\nОписание\n" + book.getDescription()
                + "\n\nКоличество лайков " + book.getLikes()
                + "\n\nПоследние комментарии\n" + book.getCommentList();

        return info;
    }
}*/