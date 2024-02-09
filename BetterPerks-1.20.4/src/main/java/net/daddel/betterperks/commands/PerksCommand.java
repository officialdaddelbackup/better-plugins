package net.daddel.betterperks.commands;

import net.daddel.betterperks.Main;
import net.daddel.betterperks.util.BuyManager;
import net.daddel.betterperks.util.GraphicalUserInterface;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PerksCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            if(strings.length == 1){
                if(strings[0].equalsIgnoreCase("reload")){
                    Main.configData.reloadConfig();
                }else if(strings[0].equalsIgnoreCase("output")){
                    BuyManager.output(p, "perks.perk1");
                }else {
                    GraphicalUserInterface.openUserInterface(p);
                }
            }else {
                GraphicalUserInterface.openUserInterface(p);
            }
        }
        return false;
    }
}
