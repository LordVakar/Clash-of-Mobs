package me.LordVakar.ClashofMobs;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import me.LordVakar.ClashofMobs.API.EconomyAPICore;
import me.LordVakar.ClashofMobs.Listeners.JoinListener;
import me.LordVakar.ClashofMobs.Troops.Barbarian;
import net.minecraft.server.v1_7_R3.BiomeBase;
import net.minecraft.server.v1_7_R3.BiomeMeta;
import net.minecraft.server.v1_7_R3.EntityInsentient;
import net.minecraft.server.v1_7_R3.EntityTypes;
import net.minecraft.server.v1_7_R3.EntityZombie;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ClashofMobs extends JavaPlugin
{
	//long john; // silver
	public static Plugin pl;
	public static FileConfiguration config;
	private static EconomyAPICore economyapi;
	
	
	public void onEnable() {
		pl = this;
		config = pl.getConfig();
		registerEvents(this, new JoinListener(this)
				);
		ClashofMobs.economyapi = new EconomyAPICore();
		//GameManager.getManager().loadArenas();
		registerEntity("Zombie", 54, EntityZombie.class, Barbarian.class);
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
	
	public void registerEntity(String name, int id, Class<? extends EntityInsentient> nmsClass, Class<? extends EntityInsentient> customClass) {
        try {
            List<Map<?, ?>> dataMaps = new ArrayList<Map<?, ?>>();
            for (Field f : EntityTypes.class.getDeclaredFields()) {
                if (f.getType().getSimpleName().equals(Map.class.getSimpleName())) {
                    f.setAccessible(true);
                    dataMaps.add((Map<?, ?>) f.get(null));
                }
            }
            if (dataMaps.get(2).containsKey(id)) {
                dataMaps.get(0).remove(name);
                dataMaps.get(2).remove(id);
            }
            Method method = EntityTypes.class.getDeclaredMethod("a", Class.class, String.class, int.class);
            method.setAccessible(true);
            method.invoke(null, customClass, name, id);
            for (Field f : BiomeBase.class.getDeclaredFields()) {
                if (f.getType().getSimpleName().equals(BiomeBase.class.getSimpleName())) {
                    if (f.get(null) != null) {
                        for (Field list : BiomeBase.class.getDeclaredFields()) {
                            if (list.getType().getSimpleName().equals(List.class.getSimpleName())) {
                                list.setAccessible(true);
                                @SuppressWarnings("unchecked")
                                List<BiomeMeta> metaList = (List<BiomeMeta>) list.get(f.get(null));
                                for (BiomeMeta meta : metaList) {
                                    Field clazz = BiomeMeta.class.getDeclaredFields()[0];
                                    if (clazz.get(meta).equals(nmsClass)) {
                                        clazz.set(meta, customClass);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
	// SAFETY PIG! IT'LL PROTECT OUR SOURCE!
	//                               _
	//  _._ _..._ .-',     _.._(`))
	// '-. `     '  /-._.-'    ',/
	//    )         \            '.
	//   / _    _    |             \
	//  |  a    a    /              |
	//  \   .-.                     ;  
	//   '-('' ).-'       ,'       ;
	//      '-;           |      .'
	//         \           \    /
	//         | 7  .__  _.-\   \
	//         | |  |  ``/  /`  /
	//        /,_|  |   /,_/   /
	//           /,_/      '`-'
}
