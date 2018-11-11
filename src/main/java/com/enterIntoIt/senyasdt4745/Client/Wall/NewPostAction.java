package com.enterIntoIt.senyasdt4745.Client.Wall;

import com.vk.api.sdk.actions.Wall;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;

public class NewPostAction {

    int groupId =1;
    UserActor actor = new UserActor(groupId, "qw");
    VkApiClient client;

    public void sendPostToWall(){
        client.wall().post(actor);
    }

    //static void post(){
      //  CheckPinPost.check();
}

