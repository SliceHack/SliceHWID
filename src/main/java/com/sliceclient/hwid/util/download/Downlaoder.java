package com.sliceclient.hwid.util.download;

import lombok.Getter;
import lombok.Setter;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * Utility class for downloading files
 *
 * @author Nick
 */
@Getter @Setter
public class Downlaoder implements Runnable {

    private String url;
    private File out;

    public Downlaoder(String url, File out) {
        this.url = url;
        this.out = out;
    }

    @Override
    public void run() {
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(out.getAbsolutePath())) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
                System.out.println("Downloading " + url);
            }
        } catch (IOException ignored) {}
    }
}
