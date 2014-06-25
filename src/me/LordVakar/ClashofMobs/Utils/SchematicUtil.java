package me.LordVakar.ClashofMobs.Utils;

import java.util.ArrayList;
import java.util.List;

import me.LordVakar.ClashofMobs.ClashofMobs;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitRunnable;

public class SchematicUtil 
{
    public static void regenerateBlocks(List<Block> blocks, final Material type, final byte data, final int blocksPerTime, final long delay){
        final List<Block> orderedBlocks = new ArrayList<Block>();
 
        orderedBlocks.addAll(blocks);
 
        final int size = orderedBlocks.size();
 
        if(size > 0){
            new BukkitRunnable(){
                int index = size - 1;
 
                @Override
                public void run(){
                    for(int i = 0; i < blocksPerTime; i++){                           
                        if(index >= 0){
                            final Block block = orderedBlocks.get(index);
 
                            regenerateBlock(block, type, data);
 
                            index -= 1;
                        } else {
                            this.cancel();
                            return;
                        }                       
                    }
                }
            }.runTaskTimer(ClashofMobs.getJavaPlugin(), 0L, delay);
        }
    }
 
    public static void regenerateBlock(Block block, final Material type, final byte data){
        final Location loc = block.getLocation();
 
        loc.getWorld().playEffect(loc, Effect.STEP_SOUND, type.getId());
 
        block.setType(type);
        block.setData(data);
    }
    
    public static void pasteSchematic(World world, Location loc, Schematic schematic)
    {
        byte[] blocks = schematic.getBlocks();
        byte[] blockData = schematic.getData();
 
        short length = schematic.getLenght();
        short width = schematic.getWidth();
        short height = schematic.getHeight();
 
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                for (int z = 0; z < length; ++z) {
                    int index = y * width * length + z * width + x;
                    Block block = new Location(world, x + loc.getX(), y + loc.getY(), z + loc.getZ()).getBlock();
                    block.setTypeIdAndData(blocks[index], blockData[index], true);
                }
            }
        }
    }
}
