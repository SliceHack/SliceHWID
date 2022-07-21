package com.sliceclient.hwid;

import com.sliceclient.hwid.discord.StartDiscordRPC;
import com.sliceclient.hwid.frame.Window;
import com.sliceclient.hwid.handler.KeyHandler;
import com.sliceclient.hwid.ui.*;
import com.sliceclient.hwid.ui.TextField;
import com.sliceclient.hwid.util.api.ServerUtil;
import com.sliceclient.hwid.util.hardware.HardwareUtil;
import lombok.Getter;
import org.json.JSONObject;

import javax.swing.*;
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

    public ServerResponse currentServerResponse;

    SliceHWID() {
        window = new Window("SliceHWID", 850, 600);
        window.getFrame().getContentPane().setBackground(Color.BLACK);

        window.addKeyListener(new KeyHandler());

        discord = new Discord();
        discord.setBounds(0, 0, 850, 600);
        window.add(discord);

        window.setResizable(false);
        window.show(true);

        StartDiscordRPC discordRPC = new StartDiscordRPC();
        discordRPC.start();
    }

    public void runWindow(JComponent remove) {
        window.remove(remove);
        runWindow();
    }

    @SuppressWarnings("all")
    public void runWindow() {
        window.add(ui = new UI_SliceHWID(window));
        window.add(textField = new TextField(150, window.getHeight() - 290, window.getWidth() - 300, 40));
        window.add(registerButton = new RegisterButton("Register", 150, window.getHeight() - (300-55), window.getWidth() - 300, 40));
        registerButton.addActionListener((e) -> {
            String server = ServerUtil.sendRequest(HardwareUtil.getHardwareID(), Long.valueOf(SliceHWID.INSTANCE.discordID), getTextField().getText());
            serverResponse(server == null ? "null" : new JSONObject(server).getString("status"));
        });
        window.add(background = new Background(800, 600));
        window.repaint();
    }

    public void serverResponse(String response) {
        window.remove(ui);
        window.remove(textField);
        window.remove(registerButton);
        window.remove(background);

        ServerResponse serverResponse = new ServerResponse(response, 0, 0, window.getWidth(), window.getHeight());
        currentServerResponse = serverResponse;
        window.add(serverResponse);

        window.add(background);
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
