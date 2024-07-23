package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "JulioVBot104_bot";
    public static final String TOKEN = "7426165561:AAE-YefaDxhxM7lhJWpSb9WDNtCcukoH-oM";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí
        if(getMessageText().equals("/start")){
            sendTextMessageAsync("¡Hola! Soy tu asistente virtual, creado por Julio Vargas. Estoy aquí para ayudarte.");
        }
        if(getMessageText().equals("Hola")){
            sendTextMessageAsync("Hola _futuro_ *programador*, ¿cómo te llamas?");
        }

        if(getMessageText().startsWith("Me llamo ")){
            String nombreUsuario = getMessageText().substring(9);
            sendTextMessageAsync(nombreUsuario + ", encantado de conocerte, soy *Gato*, ¿en qué puedo ayudarte?");
        }
    }


    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}