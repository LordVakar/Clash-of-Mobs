package me.LordVakar.ClashofMobs.Troops;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R3.inventory.CraftItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import net.minecraft.server.v1_7_R3.EntitySkeleton;
import net.minecraft.server.v1_7_R3.ItemStack;
import net.minecraft.server.v1_7_R3.World;

public class Archer extends EntitySkeleton{

	public Archer(World world) {
		super(world);
		this.setCustomName(ChatColor.RED + "Archer");
		
		this.dropChances[0] = -10.0F; //Held Item
		this.dropChances[1] = -10.0F; //Feet Slot
		this.dropChances[2] = -10.0F; //Legs Slot
		this.dropChances[3] = -10.0F; //Chest Slot
		this.dropChances[4] = -10.0F; //Head Slot
	}

    @Override
    public String getName() 
    {
        return "Archer";
    }
    
    @Override
    protected void bC() {
    	 ItemStack bow = CraftItemStack.asNMSCopy(new org.bukkit.inventory.ItemStack(Material.BOW, 1));
         //ItemStack boot = CraftItemStack.asNMSCopy(new org.bukkit.inventory.ItemStack(Material.CHAINMAIL_BOOTS, 1));
         
         CraftItemStack bukchest = CraftItemStack.asCraftCopy(new org.bukkit.inventory.ItemStack(Material.LEATHER_CHESTPLATE, 1));
         LeatherArmorMeta chestmeta = (LeatherArmorMeta) bukchest.getItemMeta();
         chestmeta.setColor(Color.GREEN);
         
         CraftItemStack bukleg = CraftItemStack.asCraftCopy(new org.bukkit.inventory.ItemStack(Material.LEATHER_LEGGINGS, 1));
         LeatherArmorMeta legmeta = (LeatherArmorMeta) bukleg.getItemMeta();
         legmeta.setColor(Color.GREEN);
         
         CraftItemStack bukhelm = CraftItemStack.asCraftCopy(new org.bukkit.inventory.ItemStack(Material.LEATHER_HELMET, 1));
         LeatherArmorMeta helmmeta = (LeatherArmorMeta) bukhelm.getItemMeta();
         helmmeta.setColor(Color.fromBGR(193, 182, 255));
         
         ItemStack chest = CraftItemStack.asNMSCopy(bukchest);
         ItemStack leg = CraftItemStack.asNMSCopy(bukleg);
         ItemStack helm = CraftItemStack.asNMSCopy(bukhelm);
         
         this.setEquipment(0, bow);
         this.setEquipment(4, helm);
         this.setEquipment(3, chest);
         this.setEquipment(2, leg);
         //this.setEquipment(1, boot);
    }
}
