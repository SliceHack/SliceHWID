package com.sliceclient.hwid.ui;

import com.sliceclient.hwid.SliceHWID;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter @Setter
public class ServerResponse extends JComponent {

    private final String response;

    public ServerResponse(String response, int x, int y, int width, int height) {
        this.response = response;
        setBounds(x, y, width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Poppins-Regular", Font.PLAIN, 50));
        g2d.drawString("Server response", getWindowWidth() / 2 - g2d.getFontMetrics().stringWidth("Server response") / 2, (getWindowHeight() / 2)-50);

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Poppins-Regular", Font.PLAIN, 25));
        g2d.drawString(response, getWindowWidth() / 2 - g2d.getFontMetrics().stringWidth(response) / 2, (getWindowHeight() / 2) );
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
