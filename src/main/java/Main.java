import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class Main {
    public static void main(String[] args) {

        //1.Инициализируем API телеграмма
        ApiContextInitializer.init();

        //2.создаём  объект телеграм бота API
        TelegramBotsApi telegram = new TelegramBotsApi();

        //3. создаем объект самого бота
        Bot bot = new Bot();
        try {
            telegram.registerBot(bot);
        }catch (TelegramApiRequestException e){
            e.printStackTrace();
        }
    }
}
