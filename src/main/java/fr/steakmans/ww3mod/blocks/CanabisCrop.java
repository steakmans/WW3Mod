package fr.steakmans.ww3mod.blocks;

import fr.steakmans.ww3mod.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class CanabisCrop extends BlockCrops {
	
	public CanabisCrop() {
		Modblocks.setBlockName(this, "canabis_crop");
	}
	
	@Override
    protected Item getSeed() {
        return null;
    }
 
    @Override
    protected Item getCrop() {
        return ModItems.CANABIS;
    }

}
