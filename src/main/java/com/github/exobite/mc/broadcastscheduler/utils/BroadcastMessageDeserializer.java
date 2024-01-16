package com.github.exobite.mc.broadcastscheduler.utils;

import com.github.exobite.mc.broadcastscheduler.gson.ChatColorDeserializer;
import com.github.exobite.mc.broadcastscheduler.models.BroadcastMessageModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.md_5.bungee.api.ChatColor;

public class BroadcastMessageDeserializer {

    static {
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        //Register Type Adapters
        gb.registerTypeAdapter(ChatColor.class, new ChatColorDeserializer());
    }

    public static BroadcastMessageModel deserialize() {
        new Gson();

        return null;
    }

}
