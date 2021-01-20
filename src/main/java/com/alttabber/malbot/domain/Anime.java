package com.alttabber.malbot.domain;

import lombok.Data;

@Data
public class Anime {

    private String name;

    public Anime(String name) {
        this.name = name;
    }
}
