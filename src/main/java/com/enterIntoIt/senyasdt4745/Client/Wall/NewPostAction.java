package com.enterIntoIt.senyasdt4745.Client.Wall;

import com.vk.api.sdk.actions.Wall;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;

public class NewPostAction {

    UserActor actor;
    VkApiClient client;

    public void sendPostToWall(){

        client.wall().post(actor);

    }

    //static void post(){
      //  CheckPinPost.check();
}

