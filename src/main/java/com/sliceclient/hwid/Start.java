package com.sliceclient.hwid;

import com.sliceclient.hwid.frame.Window;
import com.sliceclient.hwid.ui.Installing;
import com.sliceclient.hwid.util.api.ServerUtil;
import com.sliceclient.hwid.util.download.DownloadUtil;
import com.sliceclient.hwid.util.hardware.HardwareUtil;
import com.sliceclient.hwid.util.zip.UnzipUtil;

import java.awt.*;
import java.io.File;

public class Start {

    @SuppressWarnings("all")
    public static void main(String[] args) {
        Window window = new Window("Installing...", 850, 600);
        window.getFrame().getContentPane().setBackground(Color.BLACK);
        Installing installing = new Installing();
        installing.setBounds(0, 0, window.getFrame().getWidth(), window.getFrame().getHeight());

        window.add(installing);

        System.setProperty("user.dir", System.getProperty("user.home") + File.separator + "Slice");
        String path = System.getProperty("user.home") + "//Slice//assets//launcher//background";

        File filePath = new File(System.getProperty("user.home") + File.separator + "Slice");

        File parent = new File(path).getParentFile(),
                file = new File(path),
                fileFont = new File(parent + File.separator + "font"),
                zip = new File(file + File.separator + "Background.zip"),
                zipFont = new File(parent + File.separator + "Poppins.zip"),
                ziplib = new File(filePath + File.separator + "lib.zip"),
                file1 = new File(file, "frame_000_delay-0.03s.png"),
                file2 = new File(fileFont, "Poppins-Regular.ttf"),
                ofl = new File(fileFont, "OFL.txt");

        if(!parent.exists()) parent.mkdirs();
        else if(!fileFont.exists()) fileFont.mkdirs();

        if(!file1.exists() || !file2.exists()) window.show(true);

        if(!file1.exists()) {
            DownloadUtil.downloadFile("https://github.com/NickReset/SliceResources/raw/main/Background.zip", zip.getAbsolutePath());
            UnzipUtil.unzip(zip.getAbsolutePath(), zip.getParentFile().getAbsolutePath());
        }

        if(!file2.exists()) {
            DownloadUtil.downloadFile("https://github.com/NickReset/SliceResources/raw/main/Poppins.zip", zipFont.getAbsolutePath());
            UnzipUtil.unzip(zipFont.getAbsolutePath(), fileFont.getAbsolutePath());
        }

        if(zip.exists() && file1.exists()) zip.delete();
        if(zipFont.exists() && file2.exists()) zipFont.delete();
        if(ofl.exists()) ofl.delete();

        window.show(false);
        try {
            Thread.sleep(200L);
            SliceHWID instance = SliceHWID.INSTANCE;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
