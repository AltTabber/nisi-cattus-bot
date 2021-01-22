package com.alttabber.malbot.api;

import com.alttabber.malbot.domain.Anime;
import com.alttabber.malbot.resources.DiscordResourceService;
import net.dv8tion.jda.api.JDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyAnimeListController {

    @Autowired
    private DiscordResourceService discordResourceService;

    @GetMapping("/getRandomAnime")
    public Anime getRandomAnime() {

        JDA jda = discordResourceService.getJda();

        return new Anime("Naruto");
    }

}
