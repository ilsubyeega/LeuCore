package me.ilsubyeega.LeuCore.events;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class JoinQuitEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        event.setJoinMessage("§a§l[§a✓§a] §f" + event.getPlayer().getName());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event)
    {
        event.setQuitMessage("§c§l[§c✗§c] §f" + event.getPlayer().getName());
    }

}
