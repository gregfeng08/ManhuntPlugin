package me.PyroMageEx.ManhuntPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.PyroMageEx.ManhuntPlugin.Main;

public class onHuntedCrouch implements Listener{
	private Main plugin;
	public onHuntedCrouch(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void playerRespawn(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();
		if(p.getName().equals(this.plugin.hunted)) {
			if(p.isSneaking()) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 100000, 1));
			} else if(!(p.isSneaking())) {
				p.removePotionEffect(PotionEffectType.GLOWING);
			}
		}
	}

}
