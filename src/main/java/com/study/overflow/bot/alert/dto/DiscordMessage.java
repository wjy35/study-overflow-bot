package com.study.overflow.bot.alert.dto;

import lombok.*;
import org.json.JSONException;
import org.json.JSONObject;

@Data
public class DiscordMessage extends JSONObject {
    private String username;
    private String content;
    private boolean tts;

    @Builder
    public DiscordMessage(String username, String content, boolean tts){
        super();
        super.put("username",username);
        super.put("content",content);
        super.put("tts",tts);
    }

    @Override
    public String toString(int indentFactor) throws JSONException {
        return super.toString(indentFactor);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


