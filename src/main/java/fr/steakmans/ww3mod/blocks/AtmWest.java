package fr.steakmans.ww3mod.blocks;

import fr.steakmans.ww3mod.WW3Mod;
import fr.steakmans.ww3mod.gui.ATMMenu;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AtmWest extends Block {
	
	public static final String NAME = "atm_west";

	public AtmWest(Material materialIn) {
		super(materialIn);
		Modblocks.setBlockName(this, NAME);
	    setResistance(5.0F);
	    setHardness(3.0F);
	    setCreativeTab(WW3Mod.DivisionTab);	
	    }
	
	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
    
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    
    @Override
    public boolean isTranslucent(IBlockState state) {
    	return true;
    }
    
    @SideOnly(Side.CLIENT)
	@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
    		EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    	Minecraft.getMinecraft().displayGuiScreen(new ATMMenu());
    	return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }

}
