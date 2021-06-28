package fr.steakmans.ww3mod.commands;

import java.util.List;

import com.google.common.collect.Lists;

import fr.steakmans.ww3mod.items.ModItems;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class FakeIdentityCardCommand extends CommandBase {
	
	@Override
	public String getName() {
		return "fidentity";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "identity.help";
	}
	
	@Override
	public List<String> getAliases() {
		// TODO Auto-generated method stub
		return Lists.newArrayList("fid", "fidentite", "fakeid", "fakeindentity", "fakeidentite");
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(args.length < 3) {
			throw new WrongUsageException(this.getUsage(sender));
		}
		if(sender instanceof EntityPlayerMP) {
			EntityPlayerMP player = (EntityPlayerMP) sender;
			ItemStack stack = ModItems.IDENTITY.getDefaultInstance();
			if(!stack.hasTagCompound()) {
				stack.setTagCompound(new NBTTagCompound());
			}
			try {
				int age = Integer.parseInt(args[2]);
				stack.getTagCompound().setInteger("age", age);
				stack.getTagCompound().setString("nom", args[1]);
				stack.getTagCompound().setString("prenom", args[0]);
				stack.getTagCompound().setBoolean("fake", true);
				player.inventory.addItemStackToInventory(stack);
			} catch (NumberFormatException e) {
				sender.sendMessage(new TextComponentString("§4Veuillez rentrer un age correcte"));
				throw new WrongUsageException(this.getUsage(sender));
			}
		}
	}
	
	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
	    return true;
	}


}
