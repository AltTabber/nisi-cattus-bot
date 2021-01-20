package com.alttabber.malbot.resources.discord;

import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class MALDiscordListenerAdapter extends ListenerAdapter {

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        System.out.println("received message = " + event.getAuthor().getName());
        System.out.println(event.getMessage().getContentDisplay());

        if(event.getMessage().getContentRaw().startsWith("!nc")){
            String command = event.getMessage().getContentRaw().substring(3).trim();
            checkRandomDrawingTheme(command, event);
        }
    }

    private void checkRandomDrawingTheme(String command, MessageReceivedEvent event) {
        if(command.startsWith("randomTheme")){
            event.getChannel().sendMessage("Случайную тему выбрал " + event.getMember().getAsMention()).queue();
        }
    }
}
