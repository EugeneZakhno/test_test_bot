import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;

public class Transfer {

    //документ, в котором будет храниться страница
    private Document document;

    public Card() {
        connect();
    }

    //подключаемся к странице
    private void connect(){
        try{
            document = Jsoup.connect("https://www.surgebook.com/open/book/pishem-telegram-bota-na-java").get();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //получаем название обложки
    public String getTitle(){
        return document.title();
    }

    //смотрим сколько лайков
    public String getLikes(){
        Element element = document.getElementById("likes");
        return element.text();
    }

    //читаем описание
    public String getDescription(){
        Element element = document.getElementById("description");
        return element.text();
    }

    //смотрим жанр
    public String getGenres(){
        Element element = document.getElementsByClass("genres d-block").get(0);
        return element.text();
    }

    //последние комментарии
    public String getCommentList(){
        Elements elements = document.getElementsByClass("comment_mv1_item");

        String comment = elements.text();
        //чистим от ответить
        comment = comment.replaceAll("Ответить", "\n\n");
        //чистим от нравится
        comment = comment.replaceAll("Нравится", "");
        //чистим от дат
        comment = comment.replaceAll("\\d{4}-\\d{2}-\\d{2}", "");
        //чистим от времени
        comment = comment.replaceAll("\\d{4}-\\d{2}-\\d{2}", "");
        return comment;
    }

    //берем обложку книги
    public String getImage(){
        Elements elements = document.getElementsByClass("cover-book");
        String url = elements.attr("style");
        //чистим url от лишнего
        url = url.replace("background-image: url('", "");
        url = url.replace("');", "");
        return url;
    }

    //имя автора
    public String getAutorName(){
        Elements elements = document.getElementsByClass("text-decoration-none column-autor-name bold max-w-140 text-overflow-ellipsis");
        return elements.text();
    }
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