package com.enterIntoIt.senyasdt4745.Parsers.Message.Admin;

import com.enterIntoIt.senyasdt4745.Client.Admin.DataClassAdminsMassage;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.objects.messages.MessageAttachment;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AdminParser {
    static Long unixTime;
    public static DataClassAdminsMassage parseMessage(Message mes) throws ParseException, IOException {
        String parText = mes.getBody();
        List<MessageAttachment> parAttachment = mes.getAttachments();
        String [] parArray = parText.split("\n\r", 3);
        /*
        * Первая строка сообщения - тип закрепления(p/u)(parArray[0])
        * Вторая строка - время в нужном формате(написан ниже)(автоматически переводится в unixTime)
        * Остальное - текст поста(parArray[2])
        *
        * */
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
