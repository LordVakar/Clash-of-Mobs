package me.LordVakar.ClashofMobs.Listeners;

import me.LordVakar.ClashofMobs.Troops.TroopType;
import net.minecraft.server.v1_7_R3.EntityZombie;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class TroopPlaceListener implements Listener
{
	@EventHandler(priority = EventPriority.NORMAL)
	public void onCreatureSpawn(CreatureSpawnEvent e) 
	{
	    if (e.getEntityType() == EntityType.ZOMBIE) {
	    	EntityZombie zombie = (EntityZombie) e.getEntity();
	    	if(zombie.equals(TroopType.BARBARIAN)) {
	    		
	    	}
	    }
	}
}
