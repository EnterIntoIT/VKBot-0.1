package com.enterIntoIt.senyasdt4745.Request;

import com.google.gson.JsonObject;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

//обработка разных типов объектов

public class BotRequestHandler {

    private static final Logger LOG = LoggerFactory.getLogger(BotRequestHandler.class);

    private final VkApiClient apiClient;

    private final GroupActor actor;
    private final Random random = new Random();

    public BotRequestHandler(VkApiClient apiClient, GroupActor actor) {
        this.apiClient = apiClient;
        this.actor = actor;
    }

    void handleMassage(int userId) {
        try {
            apiClient.messages().send(actor).message("Hello my friend!").userId(userId).randomId(random.nextInt()).execute();
        } catch (ApiException e) {
            LOG.error("INVALID REQUEST", e);
        } catch (ClientException e) {
            LOG.error("NETWORK ERROR", e);
        }
    }
    void handleJoin(int userId){
        try {
            apiClient.messages().send(actor).message("Hello new user").userId(userId).randomId(random.nextInt()).execute();
        } catch (ApiException e) {
            LOG.error("INVALID REQUEST", e);
        } catch (ClientException e) {
            LOG.error("NETWORK ERROR", e);
        }
    }

    void handleAdmin(JsonObject object){
        Message m = (Message) object; //здесть скорее всего не так, я разбираюсь
        //хочу перестать работать с Json, но пока не знаю как
        //Уточнить в спецификации (я пока не разобрался)

    }
}