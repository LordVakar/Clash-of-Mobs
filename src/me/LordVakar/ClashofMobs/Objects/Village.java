package me.LordVakar.ClashofMobs.Objects;

import java.util.UUID;

import me.LordVakar.ClashofMobs.Managers.VillageManager;
import me.LordVakar.ClashofMobs.Utils.Util;

import org.bukkit.entity.Player;

public class Village 
{
	private String ownerName;
	private Clan clan;
	private UUID uuid;
	
	public Village(String ownerName, Clan clan) {
		this.ownerName = ownerName;
		this.clan = clan;
		Player owner = Util.getPlayer(ownerName);
		this.setUuid(owner.getUniqueId());
		VillageManager.villages.add(this);
	}
	
	public Village(String ownerName) {
		this.ownerName = ownerName;
		this.clan = null;
		Player owner = Util.getPlayer(ownerName);
		this.setUuid(owner.getUniqueId());
		VillageManager.villages.add(this);
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Clan getClan() {
		return clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}

	public UUID getUuid() {
		return uuid;
	}
	
	public Clan hasClan(String ownerName) {
		Village v = VillageManager.getManager().getPlayersVillage(Util.getPlayer(ownerName));
		if(v.clan == null) {
			return null;
		} else {
			return clan;
		}
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
}
