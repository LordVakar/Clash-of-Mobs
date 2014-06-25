package me.LordVakar.ClashofMobs;

import me.LordVakar.ClashofMobs.API.EconomyAPICore;
import me.LordVakar.ClashofMobs.Listeners.JoinListener;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ClashofMobs extends JavaPlugin
{

	public static Plugin pl;
	public static FileConfiguration config;
	private static EconomyAPICore economyapi;
	
	
	public void onEnable() {
		pl = this;
		config = pl.getConfig();
		registerEvents(this, new JoinListener(this)
				);
		//GameManager.getManager().loadArenas();
	}
	
	public void onDisable() {
		
	}
	
	//Main Utils
	public void registerCommands() 
	{	
	   // registerCommand("sg", new CmdSurvivalGames(this));
	}

	public void registerCommand(String command, CommandExecutor commandexecutor) {
	    Bukkit.getServer().getPluginCommand(command).setExecutor(commandexecutor);
	  }
	
	public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
		for (Listener listener : listeners) {
		Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
		}
		}
	
	public static JavaPlugin getJavaPlugin() {
		 JavaPlugin plugin = (JavaPlugin) pl;
		 return plugin;
	}
	
	/**
	 * Gets the EconomyAPI.
	 * @return Returns EconomyAPI.
	 */
	public static EconomyAPICore getEconomyAPI() {
		return economyapi;
	}
}
