package me.PyroMageEx.ManhuntPlugin.commands;

import java.text.DecimalFormat;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import me.PyroMageEx.ManhuntPlugin.Main;

public class Tracking implements Listener{
	private Main plugin;
	public Tracking(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void CompassClick(PlayerInteractEvent e) {
		DecimalFormat fmt = new DecimalFormat("#####.##");
		Player p = e.getPlayer();
		Material m = e.getItem().getType();
		Action a = e.getAction();
		Location loc = Bukkit.getPlayer(this.plugin.hunted).getLocation();
		
		double dist = Math.sqrt(Math.pow(loc.getX()-p.getLocation().getX(), 2)+Math.pow(loc.getY()-p.getLocation().getY(), 2));
		
		if(m == Material.COMPASS & (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK)) {
			if(Bukkit.getPlayer(this.plugin.hunted).getWorld().getEnvironment().equals(World.Environment.NETHER)) {
				p.sendMessage(this.plugin.hunted+" is currently in the nether at: "+fmt.format(loc.getX())+" "+fmt.format(loc.getY())+" "+fmt.format(loc.getZ()));
			} else {
				Player hunted = p.getServer().getPlayer(this.plugin.hunted);
				p.setCompassTarget(hunted.getLocation());
				p.sendMessage("You are now tracking "+this.plugin.hunted+" who is "+fmt.format(dist)+" blocks away.");
			}
		} 
	}

}
