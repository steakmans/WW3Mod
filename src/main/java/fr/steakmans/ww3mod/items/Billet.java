package fr.steakmans.ww3mod.items;

import fr.steakmans.ww3mod.WW3Mod;
import net.minecraft.item.Item;

public class Billet extends Item {
	
	
	public Billet(int valeur) {
		super();
		ModItems.setItemName(this, "billet_" + String.valueOf(valeur));
		setCreativeTab(WW3Mod.DivisionTab);
	}

}
