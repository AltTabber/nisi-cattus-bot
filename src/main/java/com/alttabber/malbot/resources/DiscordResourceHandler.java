package com.alttabber.malbot.resources;

import com.alttabber.malbot.resources.discord.MALDiscordListenerAdapter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.security.auth.login.LoginException;

public class DiscordResourceHandler {

    private JDA jda;

    public DiscordResourceHandler(String discordBotToken) throws LoginException {
        JDABuilder builder = JDABuilder.createDefault(discordBotToken);
        jda = builder
                .addEventListeners(new MALDiscordListenerAdapter())
                .build();
    }

    public JDA getJda() {
        return jda;
    }
}
