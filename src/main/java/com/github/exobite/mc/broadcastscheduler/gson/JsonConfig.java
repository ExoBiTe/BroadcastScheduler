package com.github.exobite.mc.broadcastscheduler.gson;

import com.github.exobite.mc.broadcastscheduler.PluginMaster;
import com.github.exobite.mc.broadcastscheduler.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;

public class JsonConfig {

    public static final String CONFIG_PATH = "config.json";

    public static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static JsonConfig instance;

    public static JsonConfig getInstance() {
        return instance;
    }

    public static void init(PluginMaster main) {
        if(instance!=null) return;
        instance = new JsonConfig(main);
    }

    private final PluginMaster main;

    //Config Values
    private boolean updateCheck;
    private boolean disableMetrics;
    private List<NewBroadcastMessageModel> messages;

    private JsonConfig(PluginMaster main) {
        this.main = main;
    }

    private boolean loadFromFile() {
        File f = Utils.createFileIfNotExists(CONFIG_PATH);
        if(f == null) {
            PluginMaster.sendConsoleMessage(Level.SEVERE, "Couldn't write config File!");
            return false;
        }
        JsonReader jr;
        try {
            jr = new JsonReader(new FileReader(f));
            jr.beginObject();
            while (jr.hasNext()) {
                String key = jr.nextName().toLowerCase(Locale.ROOT);
                switch (key) {
                    case "updatecheck" -> updateCheck = jr.nextBoolean();
                    case "disablemetrics" -> disableMetrics = jr.nextBoolean();
                    case "messages" -> messages = parseMessages(jr);
                    default -> jr.skipValue();  //Unknown key
                }
            }
        }catch(IOException e) {
            PluginMaster.sendConsoleMessage(Level.SEVERE, "Couldn't read from config File!");
            return false;
        }
        return true;
    }

    private List<NewBroadcastMessageModel> parseMessages(JsonReader jr) {

        return Arrays.asList();
    }




}
