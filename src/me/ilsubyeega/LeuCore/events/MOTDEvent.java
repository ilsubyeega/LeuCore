package me.ilsubyeega.LeuCore.events;

import org.bukkit.Bukkit;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import com.destroystokyo.paper.event.server.PaperServerListPingEvent;

public class MOTDEvent implements Listener {

    @EventHandler
    public void MOTDEvent(PaperServerListPingEvent event)
    {
        // 이 플러그인은 1.12.2에서만 사용이 가능하도록 제작되었습니다.
        // 또한 이 플러그인은 Paper를 필요로 합니다.
        event.setMotd("Plugin Testing\n" +
                "Hi");
        event.setVersion("1.12.2로만 접속이 가능합니다!");
        event.setNumPlayers(Bukkit.getOnlinePlayers().size());
        event.setProtocolVersion(340);
        event.setMaxPlayers(0);
    }


}
