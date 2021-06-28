package fr.steakmans.ww3mod.items;


import fr.steakmans.ww3mod.WW3Mod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.world.World;

public class Canabis extends ItemFood {
	
	public static final String NAME = "canabis";

	public Canabis(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		
		ModItems.setItemName(this, NAME);
	    setCreativeTab(WW3Mod.DivisionTab);
	    setMaxStackSize(16);
	    
	    setAlwaysEdible();
		
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		super.onFoodEaten(stack, worldIn, player);
		if(!worldIn.isRemote) {
			int rand = (int)Math.floor(Math.random()*(25-1+1)+1);
			if(rand != 6 && rand != 7) {
				player.addPotionEffect(new PotionEffect(Potion.getPotionById(rand), 200, 1));
			}
		}
	}
	
}
