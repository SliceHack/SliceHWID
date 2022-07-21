package com.sliceclient.hwid.ui;

import com.sliceclient.hwid.SliceHWID;
import com.sliceclient.hwid.util.api.ServerUtil;
import com.sliceclient.hwid.util.hardware.HardwareUtil;

import javax.swing.*;
import java.awt.*;

public class TextField extends JTextField {

    public TextField(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        addActionListener(e -> {
            if(getText().replace(" ", "").isEmpty())
                return;

            ServerUtil.sendRequest(HardwareUtil.getHardwareID(), Long.parseLong(SliceHWID.INSTANCE.discordDiscriminator), getText());
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        setFont(new Font("Poppins", Font.PLAIN, getHeight() - 10));
        setBackground(new Color(0, 0, 0, 155));
        setForeground(Color.WHITE);
        setCaretColor(Color.WHITE);

        super.paintComponent(g);
    }
}
