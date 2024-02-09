package net.daddel.betterperks.util;

import net.daddel.betterperks.Main;
import org.bukkit.ChatColor;

public class StringManager {
    public String getVersion(){
        return Main.getPlugin().getDescription().getVersion();
    }
    public String getAPIVersion(){
        return Main.getPlugin().getDescription().getAPIVersion();
    }
    public String getMainGUIName(){
        return ChatColor.translateAlternateColorCodes('&', Main.configData.getConfig().getString("gui.title"));
    }
    public String getBuyMenuName(){
        return ChatColor.translateAlternateColorCodes('&', Main.configData.getConfig().getString("buy.title"));
    }
    public String getConfigColorString(String string){
        return ChatColor.translateAlternateColorCodes('&', Main.configData.getConfig().getString(string));
    }
    public String getConfigString(String string){
        return Main.configData.getConfig().getString(string);
    }
    public int getConfingInt(String string){
        return Main.configData.getConfig().getInt(string);
    }
    public boolean getConfigBoolean(String string){
        return Main.configData.getConfig().getBoolean(string);
    }
}
