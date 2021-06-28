package fr.steakmans.ww3mod.commands;


import java.util.List;

import com.google.common.collect.Lists;

import fr.steakmans.ww3mod.WW3Mod;
import fr.steakmans.ww3mod.network.CharacterMessage;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class CharacterCommand extends CommandBase {
	
	@Override
	public String getName() {
	    return "character";
	}
	
	@Override
	public String getUsage(ICommandSender sender) {
	    return "character.help";
	}
	
	@Override
	public List<String> getAliases() {
	    return Lists.newArrayList("c");
	}
	
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(sender instanceof EntityPlayerMP) {
			if(WW3Mod.instance.Charact.contains(((EntityPlayerMP) sender).getUniqueID())) {
				sender.sendMessage(new TextComponentString("§aTon personnage est déjà créé. Tu ne peux plus exécuter cette commande."));
				return;
			}
			WW3Mod.network.sendTo(new CharacterMessage(), (EntityPlayerMP) sender);
		}
	}
	
	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
	    return true;
	}

}
