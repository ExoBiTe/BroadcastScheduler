package com.github.exobite.mc.broadcastscheduler.models;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.KeybindComponent;
import net.md_5.bungee.api.chat.SelectorComponent;
import org.bukkit.entity.Player;

public class BroadcastMessageModel {

    private String text;
    private String selector;
    private String keybind;
    private String translate;
    private String with;
    private String fallback;
    private String nbt;
    private String block;
    private String entity;
    private String storage;
    private String separator;
    private ScoreObjModel score;
    private String font;
    private ChatColor color;
    private boolean bold;
    private boolean italic;
    private boolean underlined;
    private boolean strikethrough;
    private boolean obfuscated;
    private HoverObjModel hoverEvent;
    private ClickObjModel clickEvent;
    private String insertion;
    private BroadcastMessageModel[] extra;

    public BaseComponent[] toComponent(Player p) {
        ComponentBuilder cp = new ComponentBuilder(text);
        if(color!=null) cp.color(color);
        if(selector!=null) cp.append(new SelectorComponent(selector));
        if(keybind!=null) cp.append(new KeybindComponent(keybind));

        return cp.create();
    }



}
