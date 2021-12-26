package me.PyroMageEx.ManhuntPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import me.PyroMageEx.ManhuntPlugin.Main;

public class OnRespawn implements Listener{
	private Main plugin;
	public OnRespawn(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void playerRespawn(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		p.getInventory().addItem(new ItemStack(Material.COMPASS));
	}

}
