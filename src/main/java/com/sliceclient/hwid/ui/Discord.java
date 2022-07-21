package com.sliceclient.hwid.ui;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

/**
 * Auth screen
 *
 * @author Nick
 * */
@Getter
public class Discord extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Poppins-Regular", Font.PLAIN, 50));
        g2d.drawString("Getting Discord Info", getWindowWidth() / 2 - g2d.getFontMetrics().stringWidth("Getting Discord Info") / 2, (getWindowHeight() / 2)-50);

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Poppins-Regular", Font.PLAIN, 25));
        g2d.drawString("Getting user DiscordID", getWindowWidth() / 2 - g2d.getFontMetrics().stringWidth("Getting user DiscordID") / 2, (getWindowHeight() / 2) );
        super.paintComponent(g);
    }

    /**
     * Gets window width
     * */
    public int getWindowWidth() {
        return (int)getBounds().getWidth();
    }

    /**
     * Gets window heigt
     * */
    public int getWindowHeight() {
        return (int)getBounds().getHeight();
    }
}
