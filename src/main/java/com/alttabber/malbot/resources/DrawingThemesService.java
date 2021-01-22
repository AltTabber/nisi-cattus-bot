package com.alttabber.malbot.resources;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

public class DrawingThemesService {

    List<String> themesList;
    Random random;

    public DrawingThemesService(List<String> themesList){
        this.themesList = themesList;
        random = new Random();
    }

    public String getRandomTheme() {
        return this.themesList.get(random.nextInt(this.themesList.size()));
    }
}
