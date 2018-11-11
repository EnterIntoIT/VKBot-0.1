package com.enterIntoIt.senyasdt4745.Client.Wall;


import com.enterIntoIt.senyasdt4745.*;
import com.enterIntoIt.senyasdt4745.Client.Actor.BotActor;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.wall.responses.PostResponse;


public class NewPostAction {

    int groupId =1;
    UserActor actor = new UserActor(groupId, "qw");
    String attachmentId  = "";
    public void sendPostToWall(){
        try {
            PostResponse postResponse = BotActor.client.wall().post(actor)
                    .attachments(attachmentId)
                    .execute();
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        //client.wall().post((UserActor) BotActor.actor);
    }

    //static void post(){
      //  CheckPinPost.check();
}

