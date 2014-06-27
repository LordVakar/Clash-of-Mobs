package me.LordVakar.ClashofMobs.Listeners;

import java.io.IOException;

import me.LordVakar.ClashofMobs.ClashofMobs;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener
{
	ClashofMobs main;
	
	public JoinListener(ClashofMobs main) {
		this.main = main;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) throws IOException {
		Player p = event.getPlayer();
		if(ClashofMobs.getEconomyAPI().isEconomySetup(p) == false) {
			ClashofMobs.getEconomyAPI().setUpEconomy(p);
		} else {
			//TODO: ADD SOMETHING TO DO.
		}
	}
}
