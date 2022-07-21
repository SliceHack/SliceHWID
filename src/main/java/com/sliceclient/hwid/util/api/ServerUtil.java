package com.sliceclient.hwid.util.api;

import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@UtilityClass
@SuppressWarnings("all")
public class ServerUtil {

    public static String API_URL = "https://api.sliceclient.com/";

    public static String sendRequest(String hwid, long discordid, String invitekey) {
        try {
            URL url = new URL(API_URL + "createAuth");
            String json = "{\"hwid\":\"" + hwid + "\",\"discordid\":\"" + discordid + "\",\"invitekey\":\"" + invitekey + "\"}";
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Content-Length", Integer.toString(json.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            connection.getOutputStream().write(json.getBytes(StandardCharsets.UTF_8));
            connection.getOutputStream().flush();
            connection.getOutputStream().close();
            return readResponse(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String readResponse(HttpURLConnection connection) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } catch (Exception ignored) {}
        return null;
    }
}
