package com.sliceclient.hwid.ui;

import javax.swing.*;
import java.awt.*;

public class RegisterButton extends JButton {

    public RegisterButton(String text, int x, int y, int width, int height) {
        setText(text);
        setBounds(x, y, width, height);
        setBackground(new Color(0, 0, 0, 155));
        setForeground(Color.WHITE);
        setBorder(null);
        setFocusable(false);

        setFont(new Font("Poppins", Font.PLAIN, getHeight() - 20));
    }

    @Override
    protected void paintComponent(Graphics g) {
        // draw white border
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        for(int i = 0; i < 4; i++) {
            g2d.drawRect(i, i, getWidth() - (i * 2), getHeight() - (i * 2));
        }
        super.paintComponent(g);
    }
}
