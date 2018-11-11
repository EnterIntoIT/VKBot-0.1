package com.enterIntoIt.senyasdt4745.Client.User;


import com.enterIntoIt.senyasdt4745.Client.Actor.BotActor;
import com.enterIntoIt.senyasdt4745.Group.DataClassUsersOfGroup;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.objects.wall.responses.PostResponse;

public class UserMassageHello extends Message {

    public static void  massage(){
        GroupActor actor = null;
        DataClassUsersOfGroup data = new DataClassUsersOfGroup();
        for (String userId : DataClassUsersOfGroup.UsersId) {
            PostResponse postResponse = BotActor.client.messages().send(actor).userId(11)
                    .message("qq")
                    .attachment()
                    .execute();

             return;

            //https://api.vk.com/method/users.get?user_id=210700286&v=5.52
        }

    }

}
