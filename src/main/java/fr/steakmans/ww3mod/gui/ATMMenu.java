package fr.steakmans.ww3mod.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import fr.steakmans.ww3mod.WW3Mod;
import fr.steakmans.ww3mod.network.AtmMessage;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;

public class ATMMenu extends GuiScreen{
	
	private GuiTextField field;
	
	@Override
	public void initGui() {
		
		GuiButton butt = new GuiButton(2, 200, 100, 50, 20, "retirer");
		this.buttonList.add(butt);
		field = new GuiTextField(1, fontRenderer, 200 , 50, 100, 20);
		field.setFocused(true);
		field.setMaxStringLength(6);
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		drawDefaultBackground();
		field.drawTextBox();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	 @Override
     protected void keyTyped(char typedChar, int keyCode) throws IOException {
		 
		 if(Character.isDigit(typedChar) || keyCode == Keyboard.KEY_BACK) {
			 field.textboxKeyTyped(typedChar, keyCode);
		 }
		 
         super.keyTyped(typedChar, keyCode);


     }

     @Override
     public void updateScreen() {
         super.updateScreen();
         field.updateCursorCounter();
     }

     @Override
     protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
         super.mouseClicked(mouseX, mouseY, mouseButton);
         field.mouseClicked(mouseX, mouseY, mouseButton);
     }
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 2) {
			if(field.getText().isEmpty()) return;
			WW3Mod.instance.network.sendToServer(new AtmMessage(field.getText()));
			mc.player.closeScreen();
		}
	}

}
