package com.enterIntoIt.senyasdt4745.Client.Actor;

import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BotActor {

    BufferedReader inpFile = new BufferedReader(
            new InputStreamReader(
                    new FileInputStream("Keys.txt")));

    UserActor actor = new GroupActor(171364230, inpFile.readLine() );
}
