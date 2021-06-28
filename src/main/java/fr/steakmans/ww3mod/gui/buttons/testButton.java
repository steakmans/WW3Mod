package fr.steakmans.ww3mod.gui.buttons;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

public class testButton extends GuiButton{

	private int x;
	private int y;
	private String resources;
	
	public testButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText, String ressource) {
		super(buttonId, x, y, widthIn, heightIn, buttonText);
		this.x = x;
		this.y = y;
		this.resources = ressource;
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
		if(visible) {
			mc.getTextureManager().bindTexture(new ResourceLocation("ww3mod", resources));
			drawModalRectWithCustomSizedTexture(x, y, 0, 0, 20, 20, 20, 20);
		}
	}

}
