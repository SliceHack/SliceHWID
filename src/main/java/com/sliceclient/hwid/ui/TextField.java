package com.sliceclient.hwid.ui;

import javax.swing.*;
import java.awt.*;

public class TextField extends JTextField {

    public TextField(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        addActionListener(e -> {
            if(getText().isEmpty())
                return;
            setText("");
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
