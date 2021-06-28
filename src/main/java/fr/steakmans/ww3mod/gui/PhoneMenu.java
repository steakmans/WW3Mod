package fr.steakmans.ww3mod.gui;

import java.io.IOException;

import org.lwjgl.util.Color;

import fr.steakmans.ww3mod.WW3Mod;
import fr.steakmans.ww3mod.gui.buttons.testButton;
import fr.steakmans.ww3mod.network.ShopMessage;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ResourceLocation;

public class PhoneMenu extends GuiScreen {

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		drawDefaultBackground();
		mc.getTextureManager().bindTexture(new ResourceLocation("ww3mod", "textures/gui/phonebackgroung.png"));
		drawModalRectWithCustomSizedTexture(mc.currentScreen.width / 2 -128, 0, 0, 0, 256, 256, 256, 256);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui() {
		super.initGui();
		testButton param = new testButton(1, mc.currentScreen.width /2 - 43, 64, 20, 20, "hello", "textures/gui/buttons/param.png");
		testButton map = new testButton(2, mc.currentScreen.width /2 - 21, 64, 20, 20, "hello", "textures/gui/buttons/map.png");
		testButton heure = new testButton(3, mc.currentScreen.width /2 + 2, 64, 20, 20, "hello", "textures/gui/buttons/heure.png");
		testButton calc = new testButton(4, mc.currentScreen.width /2 + 24, 64, 20, 20, "hello", "textures/gui/buttons/calc.png");
		testButton shop = new testButton(5, mc.currentScreen.width /2 - 43, 86, 20, 20, "hello", "textures/gui/buttons/calc.png");
		this.buttonList.add(param);
		this.buttonList.add(map);
		this.buttonList.add(heure);
		this.buttonList.add(calc);
		this.buttonList.add(shop);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 1) {
			mc.displayGuiScreen(new ParamMenu());
		}
		if(button.id == 2) {
			mc.displayGuiScreen(new MapMenu());
		}
		if(button.id == 3) {
			mc.displayGuiScreen(new TimeMenu());
		}
		if(button.id == 4) {
			mc.displayGuiScreen(new CalcMenu());
		}
		if(button.id == 5) {
			mc.displayGuiScreen(new ShopMenu());
		}
	}

}
