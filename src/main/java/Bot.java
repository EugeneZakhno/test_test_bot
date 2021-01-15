public class Bot /* extends TelegramLongPollingBot*/ {

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

        return msg;
    }

}
