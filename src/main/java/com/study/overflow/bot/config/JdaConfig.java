package com.study.overflow.bot.config;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdaConfig {

    @Bean
    public JDA jda(){
        JDA jda = JDABuilder.createDefault("MTIxMDAxODExMDM4MDE4NzY3OA.GkMqDW.5G1ZsuNexcPEyiTwOJgFtbdO1zBykBw8XwwTRM").build();
        String id = jda.getUsers().get(0).getId();

        return jda;
    }

}
