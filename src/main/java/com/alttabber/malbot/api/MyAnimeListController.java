package com.alttabber.malbot.api;

import com.alttabber.malbot.domain.Anime;
import com.alttabber.malbot.resources.DiscordResourceHandler;
import net.dv8tion.jda.api.JDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyAnimeListController {

    @Autowired
    private DiscordResourceHandler discordResourceHandler;

    @GetMapping("/getRandomAnime")
    public Anime getRandomAnime() {

        JDA jda = discordResourceHandler.getJda();

        return new Anime("Naruto");
    }

}
