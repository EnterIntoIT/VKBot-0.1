package com.enterIntoIt.senyasdt4745.Parsers.Message.Admin;

import com.enterIntoIt.senyasdt4745.Client.Admin.DataClassAdminsMassage;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.objects.messages.MessageAttachment;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

public class AdminParser extends Message {
    static Message m = new Message();
    static Long unixTime;
    public static DataClassAdminsMassage parseMessage() throws ParseException {
        String parText = m.getBody();
        List<MessageAttachment> parAttachment = m.getAttachments();
        String [] parArray = parText.split("\n\r", 3);

        AdminParser.changeDate(parArray[1]);

        return new DataClassAdminsMassage(parArray[0], unixTime, parArray[2], parAttachment);
    }

    static void changeDate(String time) throws ParseException {
        String dateString = time;
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm Z"); //формат вводимой даты публикации
        //первые две цифры - день в месяце
        //точка
        //вторые две цифры - номер месяца
        //точка
        //третие четыре цифры - год
        //пробел
        //две цифры - час публикации
        //две цифры - минута публикации
        //пробел
        //часовой пояс в формате +\-....(для нас +0300)
        Date date = dateFormat.parse(dateString);
        unixTime = (long)date.getTime()/1000;
    }

}
