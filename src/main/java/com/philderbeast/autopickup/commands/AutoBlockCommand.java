package com.philderbeast.autopickup.commands;


import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import com.philderbeast.autopickup.AutoPickupPlugin;
import com.philderbeast.autopickup.actions.AutoBlock;
import com.philderbeast.autopickup.util.Message;
import org.bukkit.entity.Player;

@CommandAlias("autoblock|atb")
public class AutoBlockCommand extends BaseCommand {
	private AutoPickupPlugin plugin;

	public AutoBlockCommand(final AutoPickupPlugin plugin) {
		this.plugin = plugin;
	}

	@CommandAlias("toggle")
	@CommandPermission("autoblock.toggle")
	public void onToggle(final Player player) {
		if (AutoPickupPlugin.autoBlock.contains(player.getName())) {
			AutoPickupPlugin.autoBlock.remove(player.getName());
			player.sendMessage(Message.SUCCESS0TOGGLE0BLOCK_OFF + "");
		} else {
			AutoPickupPlugin.autoBlock.add(player.getName());
			player.sendMessage(Message.SUCCESS0TOGGLE0BLOCK_ON + "");
		}
	}

	@Default
	@CommandPermission("autoblock.command")
	public void onAutoBlock(final Player player){
		AutoBlock.block(player);
	}
}
