package fr.steakmans.ww3mod;

import fr.steakmans.ww3mod.blocks.Modblocks;
import fr.steakmans.ww3mod.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RegisteringHandler {
	
    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ModItems.PHONE1,
        		ModItems.BLOCK_ATM_NORTH_ITEM,
        		ModItems.BLOCK_ATM_EAST_ITEM,
        		ModItems.BLOCK_ATM_SOUTH_ITEM,
        		ModItems.BLOCK_ATM_WEST_ITEM,
        		ModItems.IDENTITY,
        		ModItems.BILLET_1,
        		ModItems.BILLET_2,
        		ModItems.BILLET_5,
        		ModItems.BILLET_10,
        		ModItems.BILLET_20,
        		ModItems.BILLET_50,
        		ModItems.BILLET_100,
        		ModItems.BILLET_200,
        		ModItems.BILLET_500,
        		ModItems.CANABIS,
        		ModItems.BRIQUET,
        		ModItems.CANABISSEED,
        		ModItems.BLOCK_CARD_MACHINE,
        		ModItems.BLOCK_CARD_MACHINE_FAKE); 
    }
    
    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(Modblocks.ATM_NORTH, 
        		Modblocks.ATM_EAST,
        		Modblocks.ATM_SOUTH,
        		Modblocks.ATM_WEST,
        		Modblocks.CANABISCROP,
        		Modblocks.CARD_MACHINE_FAKE, 
        		Modblocks.CARD_MACHINE);
    }

}
