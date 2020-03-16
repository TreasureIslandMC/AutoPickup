package com.philderbeast.autopickup.commands;


import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import com.philderbeast.autopickup.AutoPickupPlugin;
import com.philderbeast.autopickup.util.Message;
import org.bukkit.entity.Player;

@CommandAlias("fullnotify|fn")
public class FullNotifyCommand extends BaseCommand {
	private AutoPickupPlugin plugin;

	public FullNotifyCommand(final AutoPickupPlugin plugin) {
		this.plugin = plugin;
	}

	@Default
	@CommandPermission("fullnotify.toggle")
	public void onToggle(final Player player) {
		if (AutoPickupPlugin.fullNotify.contains(player.getName())) {
			AutoPickupPlugin.fullNotify.remove(player.getName());
			player.sendMessage(Message.SUCCESS0TOGGLE0NOTIFY_OFF.toString());
		} else {
			AutoPickupPlugin.fullNotify.add(player.getName());
			player.sendMessage(Message.SUCCESS0TOGGLE0NOTIFY_ON.toString());
		}
	}

}
