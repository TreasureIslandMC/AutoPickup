package com.philderbeast.autopickup.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import com.philderbeast.autopickup.AutoPickupPlugin;
import com.philderbeast.autopickup.actions.AutoSmelt;
import com.philderbeast.autopickup.util.Message;
import org.bukkit.entity.Player;

@CommandAlias("autosmelt|ats")
public class AutoSmeltCommand extends BaseCommand {
	private AutoPickupPlugin plugin;

	public AutoSmeltCommand(final AutoPickupPlugin plugin) {
		this.plugin = plugin;
	}

	@CommandAlias("toggle")
	@CommandPermission("autosmelt.toggle")
	public void onToggle(final Player player){
		if (AutoPickupPlugin.autoSmelt.contains(player.getName())) {
			AutoPickupPlugin.autoSmelt.remove(player.getName());
			player.sendMessage(Message.SUCCESS0TOGGLE0SMELT_OFF + "");
		} else {
			AutoPickupPlugin.autoSmelt.add(player.getName());
			player.sendMessage(Message.SUCCESS0TOGGLE0SMELT_ON + "");
		}
	}

	@Default
	@CommandPermission("autosmelt.command")
	public void onAutoSmelt(final Player player){
		AutoSmelt.smelt(player);
	}
}
