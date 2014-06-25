package me.LordVakar.ClashofMobs.API;

import java.io.File;
import java.io.IOException;

import me.LordVakar.ClashofMobs.ClashofMobs;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;


public class EconomyAPICore
{
	ClashofMobs main;
	
	public EconomyAPICore() {
		
	}
	
	public EconomyAPICore(ClashofMobs plugin) {
		this.main = (ClashofMobs) ClashofMobs.pl;
	}
	
	/**
	 * Set the economy up for a {@link Player}.
	 * Call this on PlayerJoinEvent on join.
	 * For more effectiveness call this only if the player 
	 * has not played before on the server and if they have !isEconomySetup
	 * returning false.
	 * @param player The player to set the economy up for.
	 */
	public void setUpEconomy(Player player) {
		File folder = new File("plugins/ClashofMobs/PlayerData");
		File playerFile = new File(folder, "/" + player.getUniqueId().toString() + ".yml");
		YamlConfiguration playerFileConfig = YamlConfiguration.loadConfiguration(playerFile);
		String configPath = "PlayerData.";
		if (!folder.exists()) {
			folder.mkdir();
		}
		else if(!playerFile.exists()) {
			try {
				playerFile.createNewFile();
				playerFileConfig.set(configPath + "playerName", player.getName());
				playerFileConfig.set(configPath + "playerIP", player.getAddress().getHostString());
				playerFileConfig.set(configPath + "playerUUID", player.getUniqueId().toString());
				playerFileConfig.set(configPath + "Gold", 0);
				playerFileConfig.set(configPath + "Elixir", 0);
				playerFileConfig.set(configPath + "Clan", null);
				playerFileConfig.save(playerFile);
				playerFileConfig.load(playerFile);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InvalidConfigurationException e) {
				e.printStackTrace();
			}
		}
		else if(playerFile.exists()) {
			//Do Nothing
		}
	}
	
	/**
	 * Returns a boolean if a {@link Player}'s economy has
	 * been setup before.
	 * @param player The player to check if the economy
	 * is setup for.
	 * @return True or False.
	 */
	public boolean isEconomySetup(Player player) {
		File folder = new File("plugins/ClashofMobs/PlayerData");
		File playerFile = new File(folder, "/" + player.getUniqueId().toString() + ".yml");
		YamlConfiguration playerFileConfig = YamlConfiguration.loadConfiguration(playerFile);
		if (playerFile.exists()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Adds Gold to a {@link Player}'s balance.
	 * @param amount The amount of Gold to add.
	 * @param player The player to add Gold to.
	 */
	public void addGold(int amount, Player player) 
	{
		File folder = new File("plugins/ClashofMobs/PlayerData");
		File playerFile = new File(folder, "/" + player.getUniqueId().toString() + ".yml");
		YamlConfiguration playerFileConfig = YamlConfiguration.loadConfiguration(playerFile);
		String configPath = "PlayerData.";
		int currentGold = getGold(player);
		if(amount > 0) {
			playerFileConfig.set(configPath + "Gold", currentGold + amount);
		}
	}
	
	/**
	 * Adds Gold to a {@link Player}'s balance
	 * and displays a message.
	 * @param amount The amount of Gold to add.
	 * @param player The player to add Gold to.
	 * @param message The message to send to the player.
	 */
	public void addGold(int amount, Player player, String message) 
	{
		File folder = new File("plugins/ClashofMobs/PlayerData");
		File playerFile = new File(folder, "/" + player.getUniqueId().toString() + ".yml");
		YamlConfiguration playerFileConfig = YamlConfiguration.loadConfiguration(playerFile);
		String configPath = "PlayerData.";
		int currentGold = getGold(player);
		if(amount > 0) {
			playerFileConfig.set(configPath + "Gold", currentGold + amount);
			player.sendMessage(message);
		}
	}
	
	/**
	 * Removes Gold from a {@link Player}'s balance.
	 * @param amount The amount of Gold to remove.
	 * @param player The player to remove Gold from.
	 */
	public void removeGold(int amount, Player player) {
		File folder = new File("plugins/ClashofMobs/PlayerData");
		File playerFile = new File(folder, "/" + player.getUniqueId().toString() + ".yml");
		YamlConfiguration playerFileConfig = YamlConfiguration.loadConfiguration(playerFile);
		String configPath = "PlayerData.";
		int currentGold = getGold(player);
		if(amount > 0) {
			playerFileConfig.set(configPath + "Gold", currentGold - amount);
		}
	}
	
	/**
	 * Removes Gold from a {@link Player}'s balance
	 * and displays a message.
	 * @param amount The amount of Gold to remove.
	 * @param player The player to remove Gold from.
	 * @param message The message to send to the player.
	 */
	public void removeGold(int amount, Player player, String message) {
		File folder = new File("plugins/ClashofMobs/PlayerData");
		File playerFile = new File(folder, "/" + player.getUniqueId().toString() + ".yml");
		YamlConfiguration playerFileConfig = YamlConfiguration.loadConfiguration(playerFile);
		String configPath = "PlayerData.";
		int currentGold = getGold(player);
		if(amount > 0) {
			playerFileConfig.set(configPath + "Gold", currentGold - amount);
			player.sendMessage(message);
		}
	}
	
	/**
	 * Adds Elixir to a {@link Player}'s balance.
	 * @param amount The amount of Elixir to add.
	 * @param player The player to add Elixir to.
	 */
	public void addElixir(int amount, Player player) 
	{
		File folder = new File("plugins/ClashofMobs/PlayerData");
		File playerFile = new File(folder, "/" + player.getUniqueId().toString() + ".yml");
		YamlConfiguration playerFileConfig = YamlConfiguration.loadConfiguration(playerFile);
		String configPath = "PlayerData.";
		int currentElixir = getElixir(player);
		if(amount > 0) {
			playerFileConfig.set(configPath + "Elixir", currentElixir + amount);
		}
	}
	
	/**
	 * Adds Elixir to a {@link Player}'s balance
	 * and displays a message.
	 * @param amount The amount of Elixir to add.
	 * @param player The player to add Elixir to.
	 * @param message The message to send to the player.
	 */
	public void addElixir(int amount, Player player, String message) 
	{
		File folder = new File("plugins/ClashofMobs/PlayerData");
		File playerFile = new File(folder, "/" + player.getUniqueId().toString() + ".yml");
		YamlConfiguration playerFileConfig = YamlConfiguration.loadConfiguration(playerFile);
		String configPath = "PlayerData.";
		int currentElixir = getElixir(player);
		if(amount > 0) {
			playerFileConfig.set(configPath + "Elixir", currentElixir + amount);
			player.sendMessage(message);
		}
	}
	
	/**
	 * Removes Elixir from a {@link Player}'s balance.
	 * @param amount The amount of Elixir to remove.
	 * @param player The player to remove Elixir from.
	 */
	public void removeElixir(int amount, Player player) {
		File folder = new File("plugins/ClashofMobs/PlayerData");
		File playerFile = new File(folder, "/" + player.getUniqueId().toString() + ".yml");
		YamlConfiguration playerFileConfig = YamlConfiguration.loadConfiguration(playerFile);
		String configPath = "PlayerData.";
		int currentElixir = getElixir(player);
		if(amount > 0) {
			playerFileConfig.set(configPath + "Elixir", currentElixir - amount);
		}
	}
	
	/**
	 * Removes Elixir from a {@link Player}'s balance
	 * and displays a message.
	 * @param amount The amount of Elixir to remove.
	 * @param player The player to remove Elixir from.
	 * @param message The message to send to the player.
	 */
	public void removeElixir(int amount, Player player, String message) {
		File folder = new File("plugins/ClashofMobs/PlayerData");
		File playerFile = new File(folder, "/" + player.getUniqueId().toString() + ".yml");
		YamlConfiguration playerFileConfig = YamlConfiguration.loadConfiguration(playerFile);
		String configPath = "PlayerData.";
		int currentElixir = getElixir(player);
		if(amount > 0) {
			playerFileConfig.set(configPath + "Elixir", currentElixir - amount);
			player.sendMessage(message);
		}
	}
	
	/**
	 * Returns an int of how much Gold a
	 * {@link Player} has.
	 * @param player The player to get the Gold of.
	 */
	public int getGold(Player player) {
		File folder = new File("plugins/ClashofMobs/PlayerData");
		File playerFile = new File(folder, "/" + player.getUniqueId().toString() + ".yml");
		YamlConfiguration playerFileConfig = YamlConfiguration.loadConfiguration(playerFile);
		String configPath = "PlayerData.";
		return playerFileConfig.getInt(configPath + "Gold");
	}
	
	/**
	 * Returns an int of how much Elixir a
	 * {@link Player} has.
	 * @param player The player to get the Elixir of.
	 */
	public int getElixir(Player player) {
		File folder = new File("plugins/ClashofMobs/PlayerData");
		File playerFile = new File(folder, "/" + player.getUniqueId().toString() + ".yml");
		YamlConfiguration playerFileConfig = YamlConfiguration.loadConfiguration(playerFile);
		String configPath = "PlayerData.";
		return playerFileConfig.getInt(configPath + "Elixir");
	}
	
	/**
	 * Sets the Gold of a {@link Player}'s balance.
	 * @param amount The amount of Gold to set.
	 * @param player The player to set the Gold for.
	 */
	public void setGold(int amount, Player player) {
		File folder = new File("plugins/ClashofMobs/PlayerData");
		File playerFile = new File(folder, "/" + player.getUniqueId().toString() + ".yml");
		YamlConfiguration playerFileConfig = YamlConfiguration.loadConfiguration(playerFile);
		String configPath = "PlayerData.";
		if(amount > 0) {
			playerFileConfig.set(configPath + "Gold", amount);
		}
	}
	
	/**
	 * Sets the Gold of a {@link Player}'s balance
	 * and displays a message.
	 * @param amount The amount of Gold to set.
	 * @param player The player to set the Gold for.
	 * @param message The message to send to the player.
	 */
	public void setGold(int amount, Player player, String message) {
		File folder = new File("plugins/ClashofMobs/PlayerData");
		File playerFile = new File(folder, "/" + player.getUniqueId().toString() + ".yml");
		YamlConfiguration playerFileConfig = YamlConfiguration.loadConfiguration(playerFile);
		String configPath = "PlayerData.";
		if(amount > 0) {
			playerFileConfig.set(configPath + "Gold", amount);
			player.sendMessage(message);
		}
	}
	
	/**
	 * Sets the Elixir of a {@link Player}'s balance.
	 * @param amount The amount of Elixir to set.
	 * @param player The player to set the Elixir for.
	 */
	public void setElixir(int amount, Player player) {
		File folder = new File("plugins/ClashofMobs/PlayerData");
		File playerFile = new File(folder, "/" + player.getUniqueId().toString() + ".yml");
		YamlConfiguration playerFileConfig = YamlConfiguration.loadConfiguration(playerFile);
		String configPath = "PlayerData.";
		if(amount > 0) {
			playerFileConfig.set(configPath + "Elixir", amount);
		}
	}
	
	/**
	 * Sets the Elixir of a {@link Player}'s balance
	 * and displays a message.
	 * @param amount The amount of Elixir to set.
	 * @param player The player to set the Elixir for.
	 * @param message The message to send to the player.
	 */
	public void setElixir(int amount, Player player, String message) {
		File folder = new File("plugins/ClashofMobs/PlayerData");
		File playerFile = new File(folder, "/" + player.getUniqueId().toString() + ".yml");
		YamlConfiguration playerFileConfig = YamlConfiguration.loadConfiguration(playerFile);
		String configPath = "PlayerData.";
		if(amount > 0) {
			playerFileConfig.set(configPath + "Elixir", amount);
			player.sendMessage(message);
		}
	}
}
