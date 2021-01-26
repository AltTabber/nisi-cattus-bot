package com.alttabber.malbot.config;

import com.alttabber.malbot.resources.AnimeCharactersService;
import com.alttabber.malbot.resources.DrawingThemesService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class FileResourcesConfig {

    @Value("classpath:data/themes.txt")
    Resource themesFile;

    @Value("classpath:data/characters.txt")
    Resource animeCharactersFile;

    @Bean
    @Scope("singleton")
    public DrawingThemesService getDrawingThemesService() throws IOException {

        InputStream resource = themesFile.getInputStream();
        List<String> themes;
        try ( BufferedReader reader = new BufferedReader(
                new InputStreamReader(resource, "utf-8")) ) {
            themes = reader.lines().collect(Collectors.toList());

        }
        DrawingThemesService drawingThemesService = new DrawingThemesService(themes);

        return drawingThemesService;
    }

    @Bean
    @Scope("singleton")
    public AnimeCharactersService getAnimeCharacterService() throws IOException {

        InputStream resource = animeCharactersFile.getInputStream();
        List<String> themes;
        try ( BufferedReader reader = new BufferedReader(
                new InputStreamReader(resource, "utf-8")) ) {
            themes = reader.lines().collect(Collectors.toList());
        }
        AnimeCharactersService drawingThemesService = new AnimeCharactersService(themes);

        return drawingThemesService;
    }

}
