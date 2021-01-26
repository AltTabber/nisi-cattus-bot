package com.alttabber.malbot.resources;

import java.util.List;
import java.util.Random;

public class AnimeCharactersService {

    List<String> themesList;
    Random random;

    public AnimeCharactersService(List<String> themesList){
        this.themesList = themesList;
        random = new Random();
    }

    public String getRandomTheme() {
        return this.themesList.get(random.nextInt(this.themesList.size()));
    }
}
