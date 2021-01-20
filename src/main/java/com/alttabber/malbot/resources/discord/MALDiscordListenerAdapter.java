package com.alttabber.malbot.resources.discord;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class MALDiscordListenerAdapter extends ListenerAdapter {

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        System.out.println("received message = " + event.getAuthor().getName());
        System.out.println(event.getMessage().getContentDisplay());
    }
}
