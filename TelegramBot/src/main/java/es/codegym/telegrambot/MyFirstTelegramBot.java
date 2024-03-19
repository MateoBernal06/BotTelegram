package es.codegym.telegrambot;


import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "M_B_primer_bot_bot";
    public static final String TOKEN = "6867154294:AAH5pf12Xu5lyQQHOk_2MuouSNRMpuYpikE";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {

         /*if (getMessageText().equals("/start")) {
             sendTextMessageAsync("*BIENVENIDO*, ESTE ES MI PRIMER _BOT_  DE TELEGRAM"); //permite mandar un mensaje

         }
         else if (getMessageText().contains("Hola")||getMessageText().contains("hola")||getMessageText().contains("Hi")
                 ||getMessageText().contains("hello")||getMessageText().contains("Hello")||getMessageText().contains("hi")){

             sendTextMessageAsync("Hola futuro programador");
             sendTextMessageAsync("¿Cual es tu nombre?");


         }else if (getMessageText().contains("nombre")||getMessageText().contains("llamo")){
            sendTextMessageAsync("*Hola*, Encantado de conocerte soy *Gato* y este es mi bot");

         }*/

        String boton_jugar= "play_boton";
        String boton_charlar= "charlar_bot_boton";

        if (getMessageText().equals("/start")){

            sendTextMessageAsync("¿Que quieres hacer el dia de hoy?",Map.of(
                    "JUGAR",boton_jugar,
                    "CHARLAR CON EL BOT",boton_charlar)
            );

        }
        else if (getCallbackQueryButtonKey().equals(boton_charlar)){
            sendTextMessageAsync("Hola futuro programador!!");
            sendTextMessageAsync("Cuentame de ti... :)");

        }
        else if (getMessageText().contains("Hola")||getMessageText().contains("hola")||getMessageText().contains("Hi")
                ||getMessageText().contains("hello")||getMessageText().contains("Hello")||getMessageText().contains("hi")){
            sendTextMessageAsync("¿Cual es tu nombre?");

        }
        else if (getMessageText().contains("nombre")||getMessageText().contains("llamo")){
            sendTextMessageAsync("*Hola*, Encantado de conocerte soy *Gato* y este es mi bot");

        }
        else if (getCallbackQueryButtonKey().equals(boton_jugar)) {

            setUserGlory(0);//contador??
            sendPhotoMessageAsync("step_1_pic");//permite mandar una imagen
            sendTextMessageAsync(STEP_1_TEXT, Map.of(
                    "Romper la nevera", "nivel_uno_boton") //crea borones (nombre boton, variable)
            );

        } else if (getCallbackQueryButtonKey().equals("nivel_uno_boton")) {
            setUserGlory(30);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT, Map.of(
                    "¡Tomar una salchicha! +20 de fama", "nivel_dos_boton",
                    "¡Tomar un pescado! +20 de fama", "nivel_dos_boton",
                    "¡Tirar una lata de pepinillos! +20 de fama", "nivel_dos_boton")
            );

        } else if (getCallbackQueryButtonKey().equals("nivel_dos_boton")) {
            setUserGlory(20);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT, Map.of(
                    "Romper al robot aspirador", "nivel_tres_boton")
            );

        } else if (getCallbackQueryButtonKey().equals("nivel_tres_boton")) {
            setUserGlory(20);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT, Map.of(
                    "Enviar al robot aspirador a por comida! +30 de fama", "nivel_cuatro_boton",
                    "Dar un paseo en el robot aspirador! +30 de fama", "nivel_cuatro_boton",
                    "¡Huir del robot aspirador! +30 de fama", "nivel_cuatro_boton")
            );

        } else if (getCallbackQueryButtonKey().equals("nivel_cuatro_boton")) {
            setUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT, Map.of(
                    "Encender y ponerse la GoPro!", "nivel_cinco_boton")
            );

        } else if (getCallbackQueryButtonKey().equals("nivel_cinco_boton")) {
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT, Map.of(
                    "¡Correr por los tejados, grabar con la GoPro! +40 de fama", "nivel_seis_boton",
                    "¡Atacar a otros gatos desde tu escondite con la GoPro! +40 de fama", "nivel_seis_boton",
                    "¡Atacar a los perros desde tu escondite con la GoPro! +40 de fama", "nivel_seis_boton")
            );

        } else if (getCallbackQueryButtonKey().equals("nivel_seis_boton")) {
            setUserGlory(40);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT, Map.of(
                    "Romper la contraseña", "nivel_siete_boton")
            );

        } else if (getCallbackQueryButtonKey().equals("nivel_siete_boton")) {
            setUserGlory(40);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT, Map.of(
                    "Salir al patio", "nivel_ocho_boton")
            );

        } else if (getCallbackQueryButtonKey().equals("nivel_ocho_boton")) {
            setUserGlory(50);
            sendPhotoMessageAsync("final_pic");
            sendTextMessageAsync(FINAL_TEXT);
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}