package com.sliceclient.hwid.util.download;

import lombok.experimental.UtilityClass;

import java.io.File;

/**
 * Utility class for downloading files
 */
@UtilityClass
public class DownloadUtil {

    /**
     * Downloads a file from a URL
     *
     * @param url      the URL to download from
     * @param fileName the file to save to
     **/
    public static void downloadFile(String url, String fileName) {
        new Downlaoder(url, new File(fileName)).run();
    }
}
