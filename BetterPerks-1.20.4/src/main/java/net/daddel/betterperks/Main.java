package net.daddel.betterperks;

import net.daddel.betterperks.commands.PerksCommand;
import net.daddel.betterperks.file.configData;
import net.daddel.betterperks.listener.MainMenuListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import static net.daddel.betterperks.util.Utilities.version;

public final class Main extends JavaPlugin {
    public static Main plugin;
    public static configData configData;

    @Override
    public void onEnable() {
        plugin = this;
        configData = new configData(this);

        getLogger().info("BetterPerks " + version + " enabled");

        getCommand("perks").setExecutor(new PerksCommand());

        PluginManager plm = Bukkit.getPluginManager();
        plm.registerEvents(new MainMenuListener(), this);

        //TODO wenn String nicht vorhanden -> error msg

    }

    @Override
    public void onDisable() {
        getLogger().info("BetterPerks " + version + " disabled");
    }
    public static Main getPlugin() {
        return plugin;
    }
}
