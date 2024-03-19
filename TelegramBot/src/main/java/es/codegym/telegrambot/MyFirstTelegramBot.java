package es.codegym.telegrambot;


import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "M_B_primer_bot_bot";
    public static final String TOKEN = "6867154294:AAH5pf12Xu5lyQQHOk_2MuouSNRMpuYpikE";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {

         if (getMessageText().equals("/start")) {
             sendTextMessageAsync("*BIENVENIDO*, ESTE ES MI PRIMER _BOT_  DE TELEGRAM");

         }
         else if (getMessageText().contains("Hola")||getMessageText().contains("hola")||getMessageText().contains("Hi")
                 ||getMessageText().contains("hello")||getMessageText().contains("Hello")||getMessageText().contains("hi")){

             sendTextMessageAsync("Hola futuro programador");
             sendTextMessageAsync("¿Cual es tu nombre?");


         }else if (getMessageText().contains("nombre")||getMessageText().contains("llamo")){
            sendTextMessageAsync("*Hola*, Encantado de conocerte soy *Gato* y este es mi bot");

         }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}