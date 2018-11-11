package com.enterIntoIt.senyasdt4745.Parsers.Message;

import com.enterIntoIt.senyasdt4745.Client.User.UserMassageHello;
import com.vk.api.sdk.callback.objects.group.CallbackGroupJoin;

public class MainParser {

    CallbackGroupJoin joinToGroup = new CallbackGroupJoin();

    public void redirectToAction() {
        if(joinToGroup.getJoinType().getValue().equals("join")){
            UserMassageHello.massage();
        }  //if (CallbackMessageType = ) {
        //}
    }
}
