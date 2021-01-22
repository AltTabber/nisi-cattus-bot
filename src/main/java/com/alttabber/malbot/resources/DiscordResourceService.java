package com.alttabber.malbot.resources;

import com.alttabber.malbot.resources.discord.MALDiscordListenerAdapter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.security.auth.login.LoginException;

public class DiscordResourceService {

    private JDA jda;

    public DiscordResourceService(String discordBotToken, MALDiscordListenerAdapter malDiscordListenerAdapter) throws LoginException {
        JDABuilder builder = JDABuilder.createDefault(discordBotToken);
        jda = builder
                .addEventListeners(malDiscordListenerAdapter)
                .build();
    }

    public JDA getJda() {
        return jda;
    }
}
