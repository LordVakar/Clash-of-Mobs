package me.LordVakar.ClashofMobs.Managers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import me.LordVakar.ClashofMobs.ClashofMobs;
import me.LordVakar.ClashofMobs.Objects.Village;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class VillageManager 
{
	public static List<Village> villages = new ArrayList<Village>();
	String prefix = ChatColor.GOLD + "" + ChatColor.BOLD + "DivineVillages> " + ChatColor.RESET + ChatColor.GOLD;
	ClashofMobs main = (ClashofMobs) ClashofMobs.pl;
	private static JavaPlugin plugin = ClashofMobs.getJavaPlugin();

	private static VillageManager vm = new VillageManager();
	
	public static VillageManager getManager() {
		return vm;
	}
    
    public Village getPlayersVillage(Player player) {
        if(player == null) return null;
        for(Village v : villages) {
            if(v.getOwnerName() == null) continue;
            if(v.getOwnerName().equals(player.getName()) || v.getUuid().equals(player.getUniqueId())) return v;
        }
        return null;
    }
    
    public void createVillage(String ownerName) {
    	
    }
    
    public boolean isInVillage(Player player) {
        for(Village v : villages) {
        	if(v.getOwnerName().equals(player.getName()) || v.getUuid().equals(player.getUniqueId())) {
        		return true;
        	}
        }
		return false;
    }
}
