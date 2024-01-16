package com.github.exobite.mc.broadcastscheduler.gson;

import com.google.gson.*;
import net.md_5.bungee.api.ChatColor;

import java.lang.reflect.Type;

public class ChatColorDeserializer implements JsonDeserializer<ChatColor> {

    @Override
    public ChatColor deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException {
        String color = jsonElement.getAsString();
        return ChatColor.of(color);
    }

}
