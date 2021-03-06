package com.enterIntoIt.senyasdt4745.Client.Posts;

import com.enterIntoIt.senyasdt4745.Client.Admin.DataClassAdminsMassage;
import com.vk.api.sdk.objects.messages.MessageAttachment;

import java.text.ParseException;
import java.util.List;

public class DataClassNewPost extends DataClassAdminsMassage {

    public DataClassNewPost(Integer userId,
                            String pin,
                            Long unixTime,
                            String text,
                            List<MessageAttachment> attachments
    ) throws ParseException {
        super(userId, pin, unixTime, text, attachments);
    }
}
