package com.alttabber.malbot.config;

import com.alttabber.malbot.resources.DiscordResourceService;
import com.alttabber.malbot.resources.discord.MALDiscordListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.security.auth.login.LoginException;

@Configuration
public class DiscordBotConfig {

    @Value("${nisicattus.discord.token}")
    private String discordBotToken;

    @Autowired
    MALDiscordListenerAdapter malDiscordListenerAdapter;

    @Bean
    public DiscordResourceService getDiscordResourceService() throws LoginException {
        return new DiscordResourceService(discordBotToken, malDiscordListenerAdapter);
    }

}
