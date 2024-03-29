package com.study.overflow.bot.alert;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

@Component
@EnableScheduling
public class TimeScheduler {
    private final String WEBHOOK_URL;

    @Scheduled(cron = "0 0 9-17 ? * MON-FRI",zone = "Asia/Seoul")
    public void alertWork(){
        DiscordMessage message = DiscordMessage.builder()
                .username("곽민규")
                .content("이번 시간도 화이팅^^")
                .tts(true)
                .build();

        sendDiscordMessage(message);
    }

    @Scheduled(cron = "0 50 9-17 ? * MON-FRI",zone = "Asia/Seoul")
    public void alertRest(){
        DiscordMessage message = DiscordMessage.builder()
                .username("곽민규")
                .content("잠깐 쉬었다 합시다!")
                .tts(true)
                .build();

        sendDiscordMessage(message);
    }

    private void sendDiscordMessage(DiscordMessage message){
        URL url = null;
        HttpsURLConnection connection = null;
        OutputStream os = null;

        try {
            url = new URL(WEBHOOK_URL);

            connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.addRequestProperty("User-Agent", "Java-DiscordWebhook-BY-Gelox_");
            connection.setDoOutput(true);

            os = connection.getOutputStream();
            os.write(message.toString().getBytes("UTF-8"));
            os.flush();
            connection.getResponseCode();
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
    }

    public TimeScheduler(@Value("${study.overflow.bot.webhook.url}") String WEBHOOK_URL) {
        this.WEBHOOK_URL = WEBHOOK_URL;
    }
}
