package com.enterIntoIt.senyasdt4745.Client.User;


import com.enterIntoIt.senyasdt4745.Client.Actor.BotActor;
import com.enterIntoIt.senyasdt4745.Group.DataClassUsersOfGroup;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.objects.wall.responses.PostResponse;

public class UserMassageHello extends Message {

    public static void  massage() throws ClientException, ApiException {
        GroupActor actor = null;
        DataClassUsersOfGroup data = new DataClassUsersOfGroup();
        String attachmentId = "";
        Message message = BotActor.client.execute().messages().send(actor).userId(11)
                .randomId(11)
                .message("Hello World")
                .attachment(attachmentId)
                .execute();


             return;

            //https://api.vk.com/method/users.get?user_id=210700286&v=5.52


    }

}
