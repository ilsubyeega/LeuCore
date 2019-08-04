package me.ilsubyeega.LeuCore.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class AntiCropJumping implements Listener {


    @EventHandler
    public void AntiCropJumping(PlayerInteractEvent event)
    {

        if (event.getAction().toString().equals("PHYSICAL")) {
            String getblock = event.getPlayer().getLocation().getBlock().getType().toString();
            if (getblock.equals("SOIL") ||
                    getblock.equals("AIR") ||
                    getblock.equals("BEETROOT_BLOCK") ||
                    getblock.equals("PUMPKIN_STEM") ||
                    getblock.equals("MELON_STEM") ||
                    getblock.equals("CROPS") ||
                    getblock.equals("POTATO") ||
                    getblock.equals("CARROT")) {
                event.setCancelled(true);
            }
        }
    }


}
