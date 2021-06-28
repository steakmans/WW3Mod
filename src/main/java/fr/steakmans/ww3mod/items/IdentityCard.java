package fr.steakmans.ww3mod.items;

import fr.steakmans.ww3mod.WW3Mod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class IdentityCard extends Item {
	
	public static final String NAME = "id_card";
	
	public IdentityCard() {
		super();
		
		ModItems.setItemName(this, NAME);
	    setCreativeTab(WW3Mod.DivisionTab);
	    setMaxStackSize(1);
	}
	
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		if(!world.isRemote) {
			return super.onItemRightClick(world, player, hand);
		}
		ItemStack stack = player.getHeldItem(hand);
		if(stack.hasTagCompound()) {
			player.sendMessage(new TextComponentString("§aCarte d'identité:"));
			String name = stack.getTagCompound().getString("nom");
			player.sendMessage(new TextComponentString("§a - Nom: §7" + name));
			String firstname = stack.getTagCompound().getString("prenom");
			player.sendMessage(new TextComponentString("§a - Prenom: §7" + firstname));
			String age = String.valueOf(stack.getTagCompound().getInteger("age"));
			player.sendMessage(new TextComponentString("§a - Age: §7" + age));
			if(stack.getTagCompound().getBoolean("fake")) {
				int rand = (int)Math.floor(Math.random()*(5-1+1)+1);
				if(rand == 1) {
					player.sendMessage(new TextComponentString("§C'est une fausse carte!"));
				}
			}
		}
		return super.onItemRightClick(world, player, hand);
	}

}
