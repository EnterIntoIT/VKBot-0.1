package com.enterIntoIt.senyasdt4745.Client.Wall;

import com.enterIntoIt.senyasdt4745.Client.Admin.DataClassAdminsMassage;
import com.enterIntoIt.senyasdt4745.Client.Posts.CheckPinPost;
import com.enterIntoIt.senyasdt4745.Client.Posts.DataClassNewPost;
import com.enterIntoIt.senyasdt4745.Parsers.Message.Admin.AdminParser;
import com.vk.api.sdk.actions.Wall;
import com.vk.api.sdk.client.VkApiClient;

public class NewPostAction extends Wall {
    /**
     * Constructor
     *
     * @param client vk api client
     */
    public NewPostAction(VkApiClient client) {
        super(client);
    }



    //static void post(){
      //  CheckPinPost.check();
}

