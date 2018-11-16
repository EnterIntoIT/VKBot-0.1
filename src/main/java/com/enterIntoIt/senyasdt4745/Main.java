package com.enterIntoIt.senyasdt4745;

import com.enterIntoIt.senyasdt4745.New.Jobs.Job;
import com.enterIntoIt.senyasdt4745.New.Jobs.MembersUpdateJob;
import com.enterIntoIt.senyasdt4745.Request.BotRequestHandler;
import com.enterIntoIt.senyasdt4745.Request.RequestHandler;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import org.eclipse.jetty.server.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Main {
    private static VkApiClient vk;

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    private static List<Job> jobs = new ArrayList<>();

    private static GroupActor actor = null;

    private static Integer groupId = null;

    private final static String PROPERTIES_FILE = "Keys.properties";//файл с идентификаторами группы и тд

    private static String mode = "standalone";

    //запускаем бота

    public static void main(String[] args) throws Exception {
        init();

        run();
    }

    private static void init (){
        initJobs();
        if(isServerMode()){

        }
    }

    public static void initCient() throws FileNotFoundException {
        Properties properties = readProperties();  //создаю считыватель из файла Keys.properties

        HttpTransportClient client = new HttpTransportClient(); // открываю HTTPTransport client
        vk = new VkApiClient(client);  //Создаю вк клиента

        actor = initVkApi(vk, readProperties()); //Инициализирую группового клиента

    }

    public static void initServer()  throws Exception  {
        Properties properties = readProperties();  //создаю считыватель из файла Keys.properties

        BotRequestHandler botHandler = new BotRequestHandler(vk, actor); //Инициализирую и создаю бота

        Server server = new Server(8080); //Отркываю порт

        server.setHandler(new RequestHandler(botHandler, properties.getProperty("confirmationCode"))); //Отправляю первый запрос

        server.start(); //ПОЕХАЛИ!!
        server.join();


    }

    private static void initJobs() {
        jobs.add(new MembersUpdateJob());
        jobs.add(new NewsJob());
        jobs.add(new NotifyIssueChangesJob());
        jobs.add(new SprintEndJob());

        if (!isServerMode()) {
            jobs.add(new MessagesJob());
        }
    }

        //Инициализация бота на сервере вк

    private static GroupActor initVkApi(VkApiClient apiClient, Properties properties) {

        groupId = Integer.parseInt(properties.getProperty("groupId"));
        String token = properties.getProperty("token");
        int serverId = Integer.parseInt(properties.getProperty("serverId"));
        if (groupId == 0 || token == null || serverId == 0) throw new RuntimeException("Params are not set");
        GroupActor actor = new GroupActor(groupId, token);

        try {
            apiClient.groups().setCallbackSettings(actor, serverId).messageNew(true).execute();
        } catch (ApiException e) {
            throw new RuntimeException("Api error during init", e);
        } catch (ClientException e) {
            throw new RuntimeException("Client error during init", e);
        }

        return actor;
    }


        //Считывание всего и вся из файла

    private static Properties readProperties() throws FileNotFoundException {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE);
        if (inputStream == null)
            throw new FileNotFoundException("property file '" + PROPERTIES_FILE + "' not found in the classpath");

        try {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException("Incorrect properties file");
        }
    }


    public static GroupActor actor() {
        return actor;
    }

    public static boolean isServerMode() {
        return mode.equalsIgnoreCase("server");
    }

    public static VkApiClient vk() {
        return vk;
    }

    public static void run () throws InterruptedException {
        if (jobs.isEmpty()) {
            LOG.warn("No jobs configured. Exist");
            return;
        }

        while (true) {
            for (Job job : jobs) {
                try {
                    job.doJob();
                } catch (Exception e) {
                    LOG.error("Something wrong", e);
                }
            }

            TimeUnit.SECONDS.sleep(1);
        }
    }
}
