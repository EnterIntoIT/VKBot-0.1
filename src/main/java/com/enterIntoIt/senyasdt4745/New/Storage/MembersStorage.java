package com.enterIntoIt.senyasdt4745.New.Storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MembersStorage {
    private static final Logger LOG = LoggerFactory.getLogger(MembersStorage.class);
    private static final Set<Integer> MEMBERS = new HashSet<>();
    private static MembersStorage instance;
    private String filePath;

    public static MembersStorage getInstance() {
        if (instance == null) {
            instance = new MembersStorage();
        }

        return instance;
    }

    public void load(String path) {
        LOG.info("Load data from " + path);

        filePath = path;

        BufferedReader br = null;
        String line;


        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                deserializeLine(line);
            }

        } catch (Exception e) {
            LOG.error("Can't load " + filePath, e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    LOG.error("Can't close stream for " + filePath);
                }
            }
        }


        LOG.info("Loaded " + MEMBERS.size() + " users");
    }

    private void deserializeLine(String line) {
        Integer vkId = Integer.valueOf(line);
        MEMBERS.add(vkId);
    }

    public void add(Integer vkId) throws IOException {
        MEMBERS.add(vkId);
        save();
    }

    private void save() throws IOException {
        FileWriter writer = new FileWriter(filePath);
        for (Integer vkId : MEMBERS) {
            writer.append(serializeLine(vkId));
        }

        writer.flush();
        writer.close();
    }


    private String serializeLine(Integer vkId) {
        return vkId + "\n";
    }

    public Set<Integer> getIds() {
        return MEMBERS;
    }

    public boolean contains(Integer vkId) {
        return MEMBERS.contains(vkId);
    }
}
