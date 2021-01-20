package com.alttabber.malbot.resources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DrawingThemesHandler {

    @Value("${nisicattus.resources.drawing.themes}")
    private String drawingThemesPath;



}
