package com.github.exobite.mc.broadcastscheduler;

import com.github.exobite.mc.broadcastscheduler.command.BroadcastSchedulerCommand;
import com.github.exobite.mc.broadcastscheduler.utils.Config;
import com.github.exobite.mc.broadcastscheduler.utils.Utils;
import com.github.exobite.mc.broadcastscheduler.web.UpdateChecker;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class PluginMaster extends JavaPlugin {

    private static final int BSTATS_ID = 0;

    private static PluginMaster instance;

    public static PluginMaster getInstance() {
        return instance;
    }

    public static void sendConsoleMessage(Level level, String msg){
        String[] parts = msg.split("\n");
        for (String part : parts) {
            instance.getLogger().log(level, part);
        }
    }

    @SuppressWarnings("ConstantConditions")
    //Surpressing the getCommand(..)#setExecutor Null-Warning, as getCommand(..) never returns null in this Case.
    @Override
    public void onEnable() {
        long time1 = System.currentTimeMillis();
        instance = this;
        Utils.registerUtils(this);
        Config.setupConfig(this).loadConfig(false);
        //getServer().getPluginManager().registerEvents(new PlayerLogin(), this);
        if(Config.getInstance().checkForUpdate()) UpdateChecker.createUpdateChecker(this, true);
        if(Config.getInstance().allowMetrics()) setupBStats();
        getCommand("BroadcastScheduler").setExecutor(new BroadcastSchedulerCommand());
        sendConsoleMessage(Level.INFO, "Running (took "+(System.currentTimeMillis()-time1)+"ms)!");
    }

    private void setupBStats() {
        if(BSTATS_ID>0) new Metrics(this, BSTATS_ID);
    }

}
