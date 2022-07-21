package com.sliceclient.hwid.ui;

import com.sliceclient.hwid.frame.Window;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

/**
 * SliceHWID screen
 *
 * @author Nick
 * */
@Getter
public class UI_SliceHWID extends JComponent {

    public UI_SliceHWID(Window window) {
        setBounds(0, 0, window.getWidth(), window.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font("Verdana", Font.BOLD, 50));
        g2d.setColor(Color.WHITE);
        g2d.drawString("SliceHWID", getWindowWidth() / 2 - g2d.getFontMetrics().stringWidth("SliceHWID") / 2, (getWindowHeight() / 2)-100);

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Verdana", Font.PLAIN, 25));
        g2d.drawString("Please paste your invite key in the box below", getWindowWidth() / 2 - g2d.getFontMetrics().stringWidth("Please paste your invite key in the box below") / 2, (getWindowHeight() / 2)-50);
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
