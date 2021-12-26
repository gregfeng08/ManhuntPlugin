package me.PyroMageEx.ManhuntPlugin;


import org.bukkit.plugin.java.JavaPlugin;

import me.PyroMageEx.ManhuntPlugin.commands.Manhunt;
import me.PyroMageEx.ManhuntPlugin.commands.OnRespawn;
import me.PyroMageEx.ManhuntPlugin.commands.Tracking;
import me.PyroMageEx.ManhuntPlugin.commands.onHuntedCrouch;

public class Main extends JavaPlugin {
	public String hunted = "";
	
	@Override
	public void onEnable() {
		new Manhunt(this);
		new OnRespawn(this);
		new Tracking(this);
		new onHuntedCrouch(this);
	}
	@Override
	public void onDisable() {
		
	}
	
}
