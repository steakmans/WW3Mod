package fr.steakmans.ww3mod.gui;

import java.io.IOException;

import fr.steakmans.ww3mod.WW3Mod;
import fr.steakmans.ww3mod.gui.buttons.testButton;
import fr.steakmans.ww3mod.network.ShopMessage;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class MapMenu extends GuiScreen{
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		drawDefaultBackground();
		mc.getTextureManager().bindTexture(new ResourceLocation("ww3mod", "textures/gui/phonebackgroung.png"));
		drawModalRectWithCustomSizedTexture(mc.currentScreen.width / 2 -128, 0, 0, 0, 256, 256, 256, 256);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui() {
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		
	}

}
