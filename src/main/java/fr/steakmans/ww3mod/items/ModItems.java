package fr.steakmans.ww3mod.items;

import fr.steakmans.ww3mod.WW3Mod;
import fr.steakmans.ww3mod.blocks.Modblocks;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.datafix.fixes.ArmorStandSilent;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber(value = Side.CLIENT, modid = WW3Mod.MODID)
public class ModItems {
	
	//item
	public static final Item PHONE1 = new PHONE1();
	public static final Item IDENTITY = new IdentityCard();
	public static final Item BILLET_500 = new Billet(500);
	public static final Item BILLET_200 = new Billet(200);
	public static final Item BILLET_100 = new Billet(100);
	public static final Item BILLET_50 = new Billet(50);
	public static final Item BILLET_20 = new Billet(20);
	public static final Item BILLET_10 = new Billet(10);
	public static final Item BILLET_5 = new Billet(5);
	public static final Item BILLET_2 = new Billet(2);
	public static final Item BILLET_1 = new Billet(1);
	public static final Item BRIQUET = new Briquet();
	
	//item blocks
	public static final Item BLOCK_ATM_NORTH_ITEM = new ItemBlock(Modblocks.ATM_NORTH).setRegistryName(Modblocks.ATM_NORTH.getRegistryName());
	public static final Item BLOCK_ATM_SOUTH_ITEM = new ItemBlock(Modblocks.ATM_SOUTH).setRegistryName(Modblocks.ATM_SOUTH.getRegistryName());
	public static final Item BLOCK_ATM_WEST_ITEM = new ItemBlock(Modblocks.ATM_WEST).setRegistryName(Modblocks.ATM_WEST.getRegistryName());
	public static final Item BLOCK_ATM_EAST_ITEM = new ItemBlock(Modblocks.ATM_EAST).setRegistryName(Modblocks.ATM_EAST.getRegistryName());
	public static final Item BLOCK_CARD_MACHINE_FAKE = new ItemBlock(Modblocks.CARD_MACHINE_FAKE).setRegistryName(Modblocks.CARD_MACHINE_FAKE.getRegistryName());
	public static final Item BLOCK_CARD_MACHINE = new ItemBlock(Modblocks.CARD_MACHINE).setRegistryName(Modblocks.CARD_MACHINE.getRegistryName());
	
	//armor material
	
	//armor item
	
	//food
	public static final Item CANABIS = new Canabis(1, 1, false);
	
	//plante
	public static final Item CANABISSEED = new CanabisSeed(Modblocks.CANABISCROP, Blocks.FARMLAND);
	
    public static void setItemName(Item item, String name){
        item.setRegistryName(WW3Mod.MODID, name).setUnlocalizedName(WW3Mod.MODID + "." + name);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerItemModels(ModelRegistryEvent event){
    	registerModel(PHONE1, 0);
    	registerModel(BLOCK_ATM_NORTH_ITEM, 0);
    	registerModel(BLOCK_ATM_EAST_ITEM, 0);
    	registerModel(BLOCK_ATM_WEST_ITEM, 0);
    	registerModel(BLOCK_ATM_SOUTH_ITEM, 0);
    	registerModel(IDENTITY, 0);
    	registerModel(BILLET_1, 0);
    	registerModel(BILLET_2, 0);
    	registerModel(BILLET_5, 0);
    	registerModel(BILLET_10, 0);
    	registerModel(BILLET_20, 0);
    	registerModel(BILLET_50, 0);
    	registerModel(BILLET_100, 0);
    	registerModel(BILLET_200, 0);
    	registerModel(BILLET_500, 0);
    	registerModel(CANABIS, 0);
    	registerModel(BRIQUET, 0);
    	registerModel(CANABISSEED, 0);
    }
 
    @SideOnly(Side.CLIENT)
    public static void registerModel(Item item, int metadata){
        if (metadata < 0) metadata = 0;
        String resourceName = item.getUnlocalizedName().substring(5).replace('.', ':');
        if (metadata > 0) resourceName += "_m" + String.valueOf(metadata);
     
        ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(resourceName, "inventory"));
    
    }

}
