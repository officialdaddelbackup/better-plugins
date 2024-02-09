package net.daddel.betterperks.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class GraphicalUserInterface {
    private static StringManager stm = new StringManager();
    public static void openUserInterface(Player p){
        String perk1 = "perks.perk1.";
        String perk2 = "perks.perk2.";
        String perk3 = "perks.perk3.";
        String perk4 = "perks.perk4.";
        Inventory inventory = Bukkit.createInventory(null, 5*9, stm.getMainGUIName());
        for(int i = 0; i < 5*9; i++){
            if(i == stm.getConfingInt(perk1 + "slot")){
                setItem(Material.valueOf(stm.getConfigString(perk1 + "material")), stm.getConfigColorString(perk1 + "displayname"), "perk1", stm.getConfingInt(perk1 + "price"), inventory, i);
            }else if(i == stm.getConfingInt(perk2 + "slot")){
                setItem(Material.valueOf(stm.getConfigString(perk2 + "material")), stm.getConfigColorString(perk2 + "displayname"), "perk2", stm.getConfingInt(perk2 + "price"), inventory, i);
            }else if(i == stm.getConfingInt(perk3 + "slot")){
                setItem(Material.valueOf(stm.getConfigString(perk3 + "material")), stm.getConfigColorString(perk3 + "displayname"), "perk3", stm.getConfingInt(perk3 + "price"), inventory, i);
            }else if(i == stm.getConfingInt(perk4 + "slot")){
                setItem(Material.valueOf(stm.getConfigString(perk4 + "material")), stm.getConfigColorString(perk4 + "displayname"), "perk4", stm.getConfingInt(perk4 + "price"), inventory, i);
            }else if(i == stm.getConfingInt("gui.close.slot")){
                if(stm.getConfigBoolean("gui.close.enable")){
                    setClose(inventory, i);
                }
            }else if(stm.getConfigBoolean("gui.placeholder.enable")){
                setPlaceholder(inventory, i);
            }
        }
        p.openInventory(inventory);
    }
    private static void setItem(Material material, String displayName, String localizedName, int price, Inventory inventory, int slot){
        ItemStack is = new ItemStack(material);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(displayName);
        im.setLocalizedName(localizedName);
        im.setLore(Arrays.asList("§7Klicke um das Perk für §a" + price + "$ §7zu kaufen!", " "));
        is.setItemMeta(im);
        inventory.setItem(slot, is);
    }
    private static void setClose(Inventory inventory, int slot){
        ItemStack is = new ItemStack(Material.BARRIER);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(stm.getConfigColorString("gui.close.displayname"));
        im.setLocalizedName("close");
        is.setItemMeta(im);
        inventory.setItem(slot, is);
    }
    private static void setPlaceholder(Inventory inventory, int slot){
        ItemStack is = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(" ");
        im.setLocalizedName("placeholder");
        is.setItemMeta(im);
        inventory.setItem(slot, is);
    }
}
