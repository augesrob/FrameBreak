package com.augesrob.framebreak;

import org.bukkit.plugin.java.JavaPlugin;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class FrameBreak extends JavaPlugin implements Listener {
	  public final Logger logger = Logger.getLogger("Minecraft");
	  
	  public void onEnable(){ 
		getConfig().options().copyDefaults(true);
		saveConfig();
        getServer().getPluginManager().registerEvents(new InteractEvent(this), (Plugin)this);
		getLogger().info("#------------------#");
		getLogger().info("|      Enabled!    |");
		getLogger().info("|    Frame Break   |");
		getLogger().info("|         by       |");
		getLogger().info("|      augesrob    |");
		getLogger().info("#------------------#");
		  }
	  
	  public void onDisable() {
	    getLogger().info("----------------------");
	    getLogger().info("|      Disabled!     |");
	    getLogger().info("|    Frame Break     |");
	    getLogger().info("|        by          |");
	    getLogger().info("|     augesrob       |");
	    getLogger().info("----------------------");
	  }
	  
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		  Player player = (Player)sender;  
		  if (cmd.getName().equalsIgnoreCase("fbhelp")) {
       		    player.sendMessage(ChatColor.DARK_GREEN + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		        player.sendMessage(ChatColor.GOLD + "FrameBreak - " + ChatColor.AQUA + "Version 1.2 Coded by augesrob.com");
		        player.sendMessage(ChatColor.GOLD + "Break End Portal Frame With - " + ChatColor.AQUA + getConfig().getString("tool"));
		        player.sendMessage(ChatColor.DARK_GREEN + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		    }
			return false;
	  }
}
		       