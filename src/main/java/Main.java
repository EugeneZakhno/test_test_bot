import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;

public class Main {
    public static void main(String[] args) {

        //Инициализируем API телеграмма
        ApiContextInitializer.init();

        //создаём  объект телеграм бота API
        TelegramBotsApi telegram = new TelegramBotsApi();



    }
}
