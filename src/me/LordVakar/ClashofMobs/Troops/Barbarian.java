package me.LordVakar.ClashofMobs.Troops;

import net.minecraft.server.v1_7_R3.EntityZombie;
import net.minecraft.server.v1_7_R3.ItemStack;
import net.minecraft.server.v1_7_R3.World;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R3.inventory.CraftItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Barbarian extends EntityZombie{

	public Barbarian(World world) {
		super(world);
		this.setCustomName(ChatColor.YELLOW + "Barbarian");
		this.dropChances[0] = -10.0F; //Held Item
		this.dropChances[1] = -10.0F; //Feet Slot
		this.dropChances[2] = -10.0F; //Legs Slot
		this.dropChances[3] = -10.0F; //Chest Slot
		this.dropChances[4] = -10.0F; //Head Slot
	}
		 
    @Override
    public String getName() 
    {
        return "Barbarian";
    }
    
    @Override
    protected void bC() {
    	 ItemStack sword = CraftItemStack.asNMSCopy(new org.bukkit.inventory.ItemStack(Material.IRON_SWORD, 1));
         ItemStack helm = CraftItemStack.asNMSCopy(new org.bukkit.inventory.ItemStack(Material.GOLD_HELMET, 1));
         //ItemStack boot = CraftItemStack.asNMSCopy(new org.bukkit.inventory.ItemStack(Material.CHAINMAIL_BOOTS, 1));
         
         CraftItemStack bukchest = CraftItemStack.asCraftCopy(new org.bukkit.inventory.ItemStack(Material.LEATHER_CHESTPLATE, 1));
         LeatherArmorMeta chestmeta = (LeatherArmorMeta) bukchest.getItemMeta();
         chestmeta.setColor(Color.YELLOW);
         
         CraftItemStack bukleg = CraftItemStack.asCraftCopy(new org.bukkit.inventory.ItemStack(Material.LEATHER_LEGGINGS, 1));
         LeatherArmorMeta legmeta = (LeatherArmorMeta) bukleg.getItemMeta();
         legmeta.setColor(Color.RED);
         
         ItemStack chest = CraftItemStack.asNMSCopy(bukchest);
         ItemStack leg = CraftItemStack.asNMSCopy(bukleg);
         this.setEquipment(0, sword);
         this.setEquipment(4, helm);
         this.setEquipment(3, chest);
         this.setEquipment(2, leg);
         //this.setEquipment(1, boot);
    }
    
    
   /* @Override
    public void dropDeathLoot(boolean flag, int i)//'i' is the looting level used and 'flag' is if it was killed by a player
    {
    this.world.getWorld().dropItem(this.getBukkitEntity().getLocation(), new ItemStack(Material.DIAMOND));
    }*/

}
