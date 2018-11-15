package com.enterIntoIt.senyasdt4745.Request;

import com.enterIntoIt.senyasdt4745.Parsers.Admin.AdminTXTParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;

public class RequestHandler extends AbstractHandler {

    private final static String CONFIRMATION_TYPE = "confirmation";
    private final static String MESSAGE_TYPE = "message_new";
    private final static String OK_BODY = "ok";
    private final static String JOIN_GROUP = "group_join"; //проверить по документации

    private final BotRequestHandler botRequestHandler;
    private final String confirmationCode;
    private final Gson gson;

    public RequestHandler(BotRequestHandler handler, String confirmationCode) {
        this.botRequestHandler = handler;
        this.confirmationCode = confirmationCode;
        this.gson = new GsonBuilder().create();
    }


    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
       /* if (!"POST".equalsIgnoreCase(request.getMethod())) {
            throw new ServletException("This method is unsupported");
        }*/

        Reader reader = request.getReader();

        try {
            JsonObject requestJson = gson.fromJson(reader, JsonObject.class);

            String type = requestJson.get("type").getAsString(); //проверка пришедшего Json

            if (type == null || type.isEmpty()) throw new ServletException("No type in json");

            final String responseBody;
            switch (type) {  //switch- обработка пришедших запросов
                case JOIN_GROUP: //присоединение к группе
                    JsonObject objectJoin = requestJson.getAsJsonObject("object");
                    int userIdJoin =  objectJoin.getAsJsonPrimitive("user_id").getAsInt();
                    botRequestHandler.handleJoin(userIdJoin);
                    responseBody = OK_BODY; //возвращаю серверу ок
                    break;
                case CONFIRMATION_TYPE:
                    responseBody = confirmationCode; //подтверждение
                    break;
                case MESSAGE_TYPE:
                    JsonObject object = requestJson.getAsJsonObject("object");
                    int userId = object.getAsJsonPrimitive("user_id").getAsInt();
                    for (String idAdmin:
                         AdminTXTParser.parsAdmTxt()) { //обработка если сообщение от админа
                        if(userId == Integer.parseInt(idAdmin)){
                            botRequestHandler.handleAdmin(object);
                            break;
                        }

                    }
                    //botRequestHandler.handleMassage(userId); если сообщение не от админа (обработать и подумать)
                    responseBody = OK_BODY;
                    break;
                default:
                    responseBody = OK_BODY; // если произошло то, чего я не знаю
                    break;
            }

            response.setContentType("text/html;charset=utf-8"); //отправляю всё куда-то на сервер
            response.setStatus(HttpServletResponse.SC_OK);
            baseRequest.setHandled(true);
            response.getWriter().println(responseBody);
        } catch (JsonParseException e) {
            throw new ServletException("Incorrect json", e);
        }
    }
}
