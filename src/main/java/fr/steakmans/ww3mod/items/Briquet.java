package fr.steakmans.ww3mod.items;

import fr.steakmans.ww3mod.WW3Mod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Briquet extends Item {
	
	public static final String NAME = "briquet";

	public Briquet() {
		
		super();
		
		ModItems.setItemName(this, NAME);
	    setCreativeTab(WW3Mod.DivisionTab);
	    setMaxStackSize(1);
	    setMaxDamage(200);
        canRepair = false;
	}
	
    public ItemStack getContainerItem(ItemStack itemStack) {
        return new ItemStack(this, 1, itemStack.getItemDamage() + 1);
    }
    
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }
    
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack) {
        return false;
    }

}
