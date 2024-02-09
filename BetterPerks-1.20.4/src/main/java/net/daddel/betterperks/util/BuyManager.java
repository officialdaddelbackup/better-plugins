package net.daddel.betterperks.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class BuyManager {
    private static StringManager stm = new StringManager();
    public static void askToBuy(Player p, String path){
        Inventory inventory = Bukkit.createInventory(null, 3*9, stm.getBuyMenuName());
        for(int i = 0; i < 3*9; i++){
            if(i == 10){
                setConfirm(inventory, i);
            }else if(i == 13){
                //setBuyableItem(path, inventory, i);
            }else if(i == 16){
                //setCancel(inventory, i);
            }else if(stm.getConfigBoolean(path + "placeholder")){
                setPlaceholder(inventory, i);
            }
        }
        p.openInventory(inventory);
    }
    private static void setPlaceholder(Inventory inventory, int slot){
        ItemStack is = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(" ");
        im.setLocalizedName("placeholder");
        is.setItemMeta(im);
        inventory.setItem(slot, is);
    }
    private static void setBuyableItem(String path, Inventory inventory, int slot){
        ItemStack is = new ItemStack(Material.valueOf(stm.getConfigString(path + ".material")));
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(stm.getConfigColorString(path + ".displayname"));
        im.setLocalizedName(path);
        im.setLore(Arrays.asList("§o§lYou are about to buy this perk"));
        is.setItemMeta(im);
        inventory.setItem(slot, is);
    }
    public static void output(Player player, String path){
        player.sendMessage(stm.getConfigString(path + ".material"));
        player.sendMessage(stm.getConfigString(path + ".displayname"));
    }
    private static void setConfirm(Inventory inventory, int slot){
        Material material = Material.valueOf(stm.getConfigString("buy.confirm.material"));
        ItemStack is = new ItemStack(material);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(stm.getConfigColorString("buy.confirm.displayname"));
        im.setLore(Arrays.asList(stm.getConfigColorString("buy.confirm.description")," "));
        im.setLocalizedName("accept");
        is.setItemMeta(im);
        inventory.setItem(slot, is);
    }
    private static void setCancel(Inventory inventory, int slot){
        String string = stm.getConfigString("buy.cancel");
        ItemStack is = new ItemStack(Material.valueOf(stm.getConfigString(string + ".material")));
        ItemMeta im = is.getItemMeta();
        im.setDisplayName((string + ".displayname"));
        im.setLore(Arrays.asList((string + ".description")," "));
        im.setLocalizedName("accept");
        is.setItemMeta(im);
        inventory.setItem(slot, is);
    }
}
