package com.enterIntoIt.senyasdt4745.New.Jobs;

import com.enterIntoIt.senyasdt4745.Main;
import com.enterIntoIt.senyasdt4745.New.Storage.MembersStorage;
import com.vk.api.sdk.exceptions.ApiMessagesDenySendException;
import com.vk.api.sdk.objects.groups.responses.GetMembersResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MembersUpdateJob implements Job {
    private static final Logger LOG = LoggerFactory.getLogger(MembersUpdateJob.class);

    @Override
    public void doJob() throws Exception {
        GetMembersResponse getMembers = Main.vk().groups().getMembers(Main.actor())
                .groupId(String.valueOf(-Main.actor().getId()))
                .execute();



        Set<Integer> newMembers = new HashSet<>();
        for (Integer userId : getMembers.getItems()) {

            if (MembersStorage.getInstance().contains(userId)) {
                continue;
            }

            newMembers.add(userId);
        }

        for (Integer userId : newMembers) {
            try {
                Main.vk().messages().send(Main.actor())
                        .randomId(new Random().nextInt(10000))
                        .message("Hello")
                        .peerId(userId).execute();
            } catch (ApiMessagesDenySendException e) {
                LOG.warn("No messages with user " + userId);
            }

            MembersStorage.getInstance().add(userId);
        }
    }
}
