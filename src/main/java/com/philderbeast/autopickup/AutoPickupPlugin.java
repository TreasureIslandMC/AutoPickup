package com.philderbeast.autopickup;

import co.aikar.commands.BukkitCommandManager;
import com.philderbeast.autopickup.commands.AutoBlockCommand;
import com.philderbeast.autopickup.commands.AutoPickupCommand;
import com.philderbeast.autopickup.commands.AutoSmeltCommand;
import com.philderbeast.autopickup.commands.FullNotifyCommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.philderbeast.autopickup.listeners.MainListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class AutoPickupPlugin extends JavaPlugin {

	//TODO: move these
	public static final List<String> autoSmelt = new ArrayList<>();
	public static final List<String> autoPickup = new ArrayList<>();
	public static final List<String> autoBlock = new ArrayList<>();
	public static final List<String> fullNotify = new ArrayList<>();
	public static final Map<String, Long> warnCooldown = new HashMap<>();

	@Override
	public void onDisable() {
		Config.saveAll();
	}

	@Override
	public void onEnable() {
		Config.setConfigFolder(this.getDataFolder().getAbsolutePath());
		Config.reloadConfigs();

		getServer().getPluginManager().registerEvents(new MainListener(), this);
		registerCommands();

		for (Player p : Bukkit.getOnlinePlayers()) {
			if (p.hasPermission("autopickup.enabled")) {
				AutoPickupPlugin.autoPickup.add(p.getName());
			}
			if (p.hasPermission("autoblock.enabled")) {
				AutoPickupPlugin.autoBlock.add(p.getName());
			}
			if (p.hasPermission("autosmelt.enabled")) {
				AutoPickupPlugin.autoSmelt.add(p.getName());
			}
			if (p.hasPermission("fullnotify.enabled")) {
				AutoPickupPlugin.fullNotify.add(p.getName());
			}
		}
	}


	private void registerCommands(){
		BukkitCommandManager commandManager = new BukkitCommandManager(this);
		commandManager.registerCommand(new AutoBlockCommand(this));
		commandManager.registerCommand(new AutoPickupCommand(this));
		commandManager.registerCommand(new AutoSmeltCommand(this));
		commandManager.registerCommand(new FullNotifyCommand(this));
	}
}