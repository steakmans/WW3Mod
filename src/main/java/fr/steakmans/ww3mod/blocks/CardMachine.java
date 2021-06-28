package fr.steakmans.ww3mod.blocks;

import fr.steakmans.ww3mod.WW3Mod;
import fr.steakmans.ww3mod.gui.CardMachineFakeMenu;
import fr.steakmans.ww3mod.gui.CardMachineMenu;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CardMachine extends Block {
	
	public static String NAME = "card_machine";
	public static boolean FAKE;

	public CardMachine(Material materialIn) {
		super(materialIn);
		Modblocks.setBlockName(this, NAME);
	    setResistance(5.0F);
	    setHardness(3.0F);
	    setCreativeTab(WW3Mod.DivisionTab);	
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		Minecraft.getMinecraft().displayGuiScreen(new CardMachineMenu());
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}

}
