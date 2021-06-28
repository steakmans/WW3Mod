package fr.steakmans.ww3mod.items;

import fr.steakmans.ww3mod.WW3Mod;
import fr.steakmans.ww3mod.gui.PhoneMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PHONE1 extends Item {
	
	public static final String NAME = "phone1";
	
    public PHONE1()
    {
        super();
 
        ModItems.setItemName(this, NAME);
        setCreativeTab(WW3Mod.DivisionTab);
        setMaxStackSize(1);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
    	Minecraft.getMinecraft().displayGuiScreen(new PhoneMenu());
    	return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
