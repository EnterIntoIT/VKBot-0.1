package com.enterIntoIt.senyasdt4745.Client.Posts;

import com.enterIntoIt.senyasdt4745.Client.Admin.DataClassAdminsMassage;

public class CheckPinPost {
    public static boolean check(DataClassAdminsMassage newPost){
        return (newPost.pin.equals("p")?true:false);
    }
}
