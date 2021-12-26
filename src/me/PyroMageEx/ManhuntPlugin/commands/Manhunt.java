package me.PyroMageEx.ManhuntPlugin.commands;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.PyroMageEx.ManhuntPlugin.Main;
import net.md_5.bungee.api.ChatColor;


public class Manhunt implements CommandExecutor{

	private Main plugin;
	public Manhunt(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("track").setExecutor(this);
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		//Reset previous hunted player's glowing effect
		Bukkit.getPlayer(this.plugin.hunted).removePotionEffect(PotionEffectType.GLOWING);
		
		//Set new hunted player's effects
		this.plugin.hunted = args[0];
		Player hntd = Bukkit.getPlayer(this.plugin.hunted);
		Bukkit.broadcastMessage(ChatColor.GOLD+""+ChatColor.BOLD+this.plugin.hunted+" is now being hunted!");
		hntd.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 100000, 1));
		return true;
	}
}
