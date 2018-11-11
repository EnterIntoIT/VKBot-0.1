package com.enterIntoIt.senyasdt4745.Client.User;


import com.enterIntoIt.senyasdt4745.Group.DataClassUsersOfGroup;
import com.vk.api.sdk.callback.objects.messages.CallbackMessage;
import com.vk.api.sdk.objects.apps.App;
import com.vk.api.sdk.objects.messages.Message;

public class UserMassageHello extends Message {

    public static void  massage(){
        DataClassUsersOfGroup data = new DataClassUsersOfGroup();
        for (String userId : DataClassUsersOfGroup.UsersId) {
             Message m = new Message();

             return;

            //https://api.vk.com/method/users.get?user_id=210700286&v=5.52
        }

    }

}
