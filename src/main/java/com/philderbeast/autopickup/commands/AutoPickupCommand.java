package com.philderbeast.autopickup.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import com.philderbeast.autopickup.AutoPickupPlugin;
import com.philderbeast.autopickup.util.Message;
import org.bukkit.entity.Player;

@CommandAlias("autopickup|atp")
public class AutoPickupCommand extends BaseCommand {
	private AutoPickupPlugin plugin;


	public AutoPickupCommand(final AutoPickupPlugin plugin) {
		this.plugin = plugin;
	}

	@CommandAlias("toggle")
	@CommandPermission("autopickup.toggle")
	public void onToggle(final Player player){
		if (AutoPickupPlugin.autoPickup.contains(player.getName())) {
			AutoPickupPlugin.autoPickup.remove(player.getName());
			player.sendMessage(Message.SUCCESS0TOGGLE0PICKUP_OFF.toString());
		} else {
			AutoPickupPlugin.autoPickup.add(player.getName());
			player.sendMessage(Message.SUCCESS0TOGGLE0PICKUP_ON.toString());
		}
	}

	@Default
	public void onGui(final Player player){
		//opengui
	}
}
