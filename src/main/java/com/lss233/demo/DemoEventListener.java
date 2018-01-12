package com.lss233.demo;

import com.lss233.phoenix.Phoenix;
import com.lss233.phoenix.entity.living.Player;
import com.lss233.phoenix.event.EventHandler;
import com.lss233.phoenix.event.EventListener;
import com.lss233.phoenix.event.network.ClientConnectionEvent;

import java.util.Optional;

/**
 *
 */
public class DemoEventListener implements EventListener {
    @EventHandler
    public void onPlayerLogin(ClientConnectionEvent.Join event) {
        Optional playerOptional = event.getCause().get("player", Player.class);
        if(playerOptional.isPresent()){
            Player player = (Player) playerOptional.get();
            Phoenix.getLogger("Demo").info(String.format("%s <%s> joined server.", player.getName(), player.getUniqueId().toString()));
        }
    }

    @EventHandler
    public void onPlayerQuit(ClientConnectionEvent.Disconnect event){
        Optional playerOptional = event.getCause().get("player", Player.class);
        if(playerOptional.isPresent()){
            Player player = (Player) playerOptional.get();
            Phoenix.getLogger("Demo").info(String.format("%s <%s> left server.", player.getName(), player.getUniqueId().toString()));
        }
    }
}
