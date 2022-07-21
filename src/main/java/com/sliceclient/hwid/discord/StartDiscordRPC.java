package com.sliceclient.hwid.discord;

import com.sliceclient.hwid.SliceHWID;
import net.arikia.dev.drpc.DiscordEventHandlers;

import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;

public class StartDiscordRPC {

    private boolean running = true;
    private long created = 0;

    public void start() {

        this.created = System.currentTimeMillis();

        DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(user -> {
            System.out.println("Welcome " + user.username + "#" + user.discriminator);
            SliceHWID.INSTANCE.discordName = user.username;
            SliceHWID.INSTANCE.discordID = user.userId;
            SliceHWID.INSTANCE.discordDiscriminator = user.discriminator;
            SliceHWID.INSTANCE.runWindow(SliceHWID.INSTANCE.getDiscord());
        }).build();

        DiscordRPC.discordInitialize("984300399534170113", handlers, true);

        new Thread(() -> {

            while (running) {
                DiscordRPC.discordRunCallbacks();
            }
        }).start();
    }

    public void shutdown() {
        running = false;
        DiscordRPC.discordShutdown();
    }

    public void update(String firstLine, String secondLine) {
        DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondLine);
        b.setBigImage("slice", "");
        b.setDetails(firstLine);
        b.setStartTimestamps(created);

        DiscordRPC.discordUpdatePresence(b.build());
    }



}