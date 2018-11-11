package com.enterIntoIt.senyasdt4745.Parsers.Message;

import com.enterIntoIt.senyasdt4745.Client.User.UserMassageHello;
import com.vk.api.sdk.actions.Groups;
import com.vk.api.sdk.callback.objects.group.CallbackGroupJoin;
import com.vk.api.sdk.callback.objects.messages.CallbackMessage;
import com.vk.api.sdk.callback.objects.messages.CallbackMessageType;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.objects.messages.Action;
import org.graalvm.compiler.core.common.GraalOptions;

public class MainParser {

    CallbackGroupJoin joinToGroup = new CallbackGroupJoin();

    public void redirectToAction() {
        if(joinToGroup.getJoinType().getValue().equals("join")){
            UserMassageHello.massage();
        }  //if (CallbackMessageType = ) {
        //}
    }
}
