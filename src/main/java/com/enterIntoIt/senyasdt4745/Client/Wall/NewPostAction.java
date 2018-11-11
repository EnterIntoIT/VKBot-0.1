package com.enterIntoIt.senyasdt4745.Client.Wall;

import com.vk.api.sdk.actions.Wall;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;

public class NewPostAction l {

    UserActor actor;
    VkApiClient client;

    public void sendPostToWall(){
        Wall newPost= new Wall(client);
        newPost.post(actor);
    }

    //static void post(){
      //  CheckPinPost.check();
}

