package fr.steakmans.ww3mod.proxy;

import java.io.File;

import fr.steakmans.ww3mod.gui.CustomMainMenu;
import fr.steakmans.ww3mod.gui.RegisterCharacter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(File configFile) {
		super.preInit(configFile);
	}

	@Override
	public void init() {
		super.init();
	}
	
   /** @SubscribeEvent
    public void onOpenGui(GuiOpenEvent event)
    {
        if(event.getGui() != null && event.getGui().getClass() == GuiMainMenu.class)
        {
            event.setGui(new CustomMainMenu());
        }
    }**/
	

}
