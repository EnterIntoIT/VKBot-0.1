package com.enterIntoIt.senyasdt4745.Client.Actor;

import com.vk.api.sdk.client.VkApiClient;

import java.io.*;

public class BotActor {

    public static VkApiClient client;

    static BufferedReader inpFile;

    static {
        int i = 1;
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

}