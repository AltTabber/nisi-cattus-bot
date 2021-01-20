package com.alttabber.malbot.config;

import com.alttabber.malbot.resources.DiscordResourceHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.security.auth.login.LoginException;

@Configuration
public class DiscordBotConfig {

    @Value("${nisicattus.discord.token}")
    private String discordBotToken;

    @Bean
    public DiscordResourceHandler getDiscordResourceHandler() throws LoginException {
        return new DiscordResourceHandler(discordBotToken);
    }

}
