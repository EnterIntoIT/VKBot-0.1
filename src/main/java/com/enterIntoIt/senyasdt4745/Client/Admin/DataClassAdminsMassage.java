package com.enterIntoIt.senyasdt4745.Client.Admin;

import com.vk.api.sdk.objects.messages.MessageAttachment;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DataClassAdminsMassage {
    public String pin;
    //public String time;
    public String text;
    public List<MessageAttachment> attachments;
    public Integer from_group = 1;
    public Integer ownerID; //Id нашего сообщества
    public Long unixTime;
    public Integer signed = 0;
    public Integer postId;



    //public void checkPin(String pin);


    public DataClassAdminsMassage(String pin, Long unixTime, String text, List<MessageAttachment> attachments) throws ParseException {
        this.pin = pin;
        this.unixTime= unixTime;
        this.text = text;
        this.attachments = attachments;

    }
}
