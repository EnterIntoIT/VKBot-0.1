package com.enterIntoIt.senyasdt4745.Client.Admin;

import com.vk.api.sdk.objects.messages.MessageAttachment;

import java.text.ParseException;
import java.util.List;

public class DataClassAdminsMassage {
    public String pin;
    public String text;
    public List<MessageAttachment> attachments;
    public Integer from_group = 1; //пост от имени группы
    public Integer ownerID; //Id нашего сообщества
    public Long unixTime;
    public Integer signed = 0; // не подписывать отправителя поста
    public Integer postId; //Id поста
    public Integer userId;

    public DataClassAdminsMassage(Integer userId, String pin, Long unixTime, String text, List<MessageAttachment> attachments) throws ParseException {
        this.userId = userId;
        this.pin = pin;
        this.unixTime= unixTime;
        this.text = text;
        this.attachments = attachments;
    }
}
