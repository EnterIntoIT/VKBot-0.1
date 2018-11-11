package com.enterIntoIt.senyasdt4745.Client.Actor;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.Actor;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;

import java.io.*;

public class BotActor {

    public static VkApiClient client;

    static BufferedReader inpFile;

    static {
        try {
            inpFile = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("Keys.txt")));
        } catch (FileNotFoundException e) {
        }
        try {
            inpFile.close();
        } catch (IOException e) {
        }
    }

    public static Actor actor;

    static {
        try {
            actor = new GroupActor(171364230, inpFile.readLine() );
        } catch (IOException e) {
        }
    }

    public BotActor() throws IOException {
    }
}
