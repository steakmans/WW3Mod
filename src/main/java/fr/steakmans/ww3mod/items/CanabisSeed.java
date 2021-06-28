package fr.steakmans.ww3mod.items;

import fr.steakmans.ww3mod.WW3Mod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;

public class CanabisSeed extends ItemSeeds {
	
	public static final String NAME = "canabis_seed";

	public CanabisSeed(Block crops, Block soil) {
		super(crops, soil);
		
		ModItems.setItemName(this, NAME);
	    setCreativeTab(WW3Mod.DivisionTab);

	}

}
