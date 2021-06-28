package fr.steakmans.ww3mod.blocks;

import fr.steakmans.ww3mod.WW3Mod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTest extends Block {
	
	public static final String NAME = "test";

	public BlockTest(Material materialIn) {
		super(materialIn);
		Modblocks.setBlockName(this, NAME);
	    setResistance(5.0F);
	    setHardness(3.0F);
	    setCreativeTab(WW3Mod.DivisionTab);
	}

}
