package com.enterIntoIt.senyasdt4745.Parsers.Message;

import com.enterIntoIt.senyasdt4745.Client.User.UserMassageHello;
import com.enterIntoIt.senyasdt4745.Parsers.Message.Admin.AdminParser;
import com.vk.api.sdk.callback.CallbackApi;
import com.vk.api.sdk.callback.objects.group.CallbackGroupJoin;
import com.vk.api.sdk.objects.messages.Message;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class MainParser {

    public Integer groupId = 1;

    CallbackApi api = new CallbackApi();
    Message mes = new Message();

    CallbackGroupJoin joinToGroup = new CallbackGroupJoin();



    public void redirectToAction() throws IOException, ParseException {

        AdminParser.parseMessage(mes); //временно для проверки


        if(joinToGroup.getJoinType().getValue() == "join"){
            UserMassageHello.massage();
        } else {

            if (ifAdmin()) {
                AdminParser.parseMessage(mes);
            }
        }
    }

    boolean ifAdmin() throws IOException {
        BufferedReader inpFile = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("/home/arseny/VK 0.1/VKBot-0.1/src/main/java/com/enterIntoIt/AdminID.txt")));
        String [] adminsId = inpFile.readLine().split(" ");
        for (String adminId: adminsId
        ) {
            if(mes.getUserId() == Integer.parseInt(adminId)){
                inpFile.close();
                return true;
            }
        }
        inpFile.close();
        return false;

    }
}
