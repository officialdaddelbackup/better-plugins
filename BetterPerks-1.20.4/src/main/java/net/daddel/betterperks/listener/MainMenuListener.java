package net.daddel.betterperks.listener;

import net.daddel.betterperks.util.BuyManager;
import net.daddel.betterperks.util.StringManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MainMenuListener implements Listener {
    private StringManager stm = new StringManager();
    @EventHandler
    public void onClickActiveCommands(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getCurrentItem() == null) return;
        if (e.getCurrentItem().getItemMeta() == null) return;
        if (e.getView().getTitle().equalsIgnoreCase(stm.getMainGUIName())) {
            if(e.getCurrentItem().getItemMeta().hasLocalizedName()) {
                e.setCancelled(true);
                switch (e.getCurrentItem().getItemMeta().getLocalizedName()){
                    case "perk1":
                        BuyManager.askToBuy(p, "perks.perk1");
                        break;
                    case "perk2":
                        BuyManager.askToBuy(p, "perks.perk2");
                        break;
                    case "perk3":
                        BuyManager.askToBuy(p, "perks.perk3");
                        break;
                    case "perk4":
                        BuyManager.askToBuy(p, "perks.perk4");
                        break;
                    case "close":
                        p.closeInventory();
                        break;
                }
            }
        }
    }
}
