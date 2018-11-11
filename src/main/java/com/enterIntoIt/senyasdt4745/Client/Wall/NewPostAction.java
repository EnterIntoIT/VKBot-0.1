package com.enterIntoIt.senyasdt4745.Client.Wall;


import com.enterIntoIt.senyasdt4745.*;
import com.enterIntoIt.senyasdt4745.Client.Actor.BotActor;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;

public class NewPostAction {

    int groupId =1;
    //UserActor actor = new UserActor(groupId, "qw");
    VkApiClient client;

    public void sendPostToWall(){
        client.wall().post((UserActor) BotActor.actor);
    }

    //static void post(){
      //  CheckPinPost.check();
}

