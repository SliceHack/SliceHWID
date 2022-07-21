package com.sliceclient.hwid;

import com.sliceclient.hwid.discord.StartDiscordRPC;
import com.sliceclient.hwid.frame.Window;
import com.sliceclient.hwid.ui.*;
import com.sliceclient.hwid.ui.TextField;
import lombok.Getter;

import java.awt.*;

/**
 * SliceHWID instance
 *
 * @author Nick
 * */
@Getter
public enum SliceHWID {
    INSTANCE;

    private final Window window;

    private Background background;
    private TextField textField;
    private RegisterButton registerButton;
    private UI_SliceHWID ui;

    private final Discord discord;

    public String discordName, discordID, discordDiscriminator;

    SliceHWID() {
        window = new Window("SliceHWID", 850, 600);
        window.getFrame().getContentPane().setBackground(Color.BLACK);

        discord = new Discord();
        discord.setBounds(0, 0, 850, 600);
        window.add(discord);
//
        window.setResizable(false);
        window.show(true);

        StartDiscordRPC discordRPC = new StartDiscordRPC();
        discordRPC.start();
    }

    public void runWindow() {
        window.remove(discord);
        window.add(ui = new UI_SliceHWID(window));
        window.add(textField = new TextField(150, window.getHeight() - 290, window.getWidth() - 300, 40));
        window.add(registerButton = new RegisterButton("Register", 150, window.getHeight() - (300-55), window.getWidth() - 300, 40));
        window.add(background = new Background(800, 600));
        window.repaint();
    }

    public void update() {
        if (getBackground() != null) {
            Background background = getBackground();
            background.setBounds(0, 0, getWindow().getFrame().getWidth(), getWindow().getFrame().getHeight());
        }
        if (getUi() != null) {
            UI_SliceHWID ui = getUi();
            ui.setBounds(0, 0, getWindow().getFrame().getWidth(), getWindow().getFrame().getHeight());
        }
        window.repaint();
    }
}
