package fr.steakmans.ww3mod.blocks;

import fr.steakmans.ww3mod.WW3Mod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Modblocks {
	
	public static final Block ATM_NORTH = new Atm(Material.IRON);
	public static final Block ATM_EAST = new AtmEast(Material.IRON);
	public static final Block ATM_WEST = new AtmWest(Material.IRON);
	public static final Block ATM_SOUTH = new AtmSouth(Material.IRON);
	public static final Block CARD_MACHINE_FAKE = new CardMachineFake(Material.IRON);
	public static final Block CARD_MACHINE = new CardMachine(Material.IRON);
	public static Block CANABISCROP = new CanabisCrop();

    public static void setBlockName(Block block, String name){
    	block.setRegistryName(WW3Mod.MODID, name).setUnlocalizedName(WW3Mod.MODID + "." + name);
    }
	
}
