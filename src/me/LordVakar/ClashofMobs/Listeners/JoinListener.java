package me.LordVakar.ClashofMobs.Listeners;

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
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		ClashofMobs.getEconomyAPI().setUpEconomy(p);
	}
}
