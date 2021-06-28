package fr.steakmans.ww3mod.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import fr.steakmans.ww3mod.WW3Mod;
import fr.steakmans.ww3mod.network.AtmMessage;
import fr.steakmans.ww3mod.network.IdFakeMessage;
import fr.steakmans.ww3mod.network.IdMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;

public class CardMachineFakeMenu extends GuiScreen {
	
	private GuiTextField prenom;
	private GuiTextField nom;
	private GuiTextField age;
	
	@Override
	public void initGui() {
		Mouse.setGrabbed(false);
		Keyboard.enableRepeatEvents(true);
		prenom = new GuiTextField(1, fontRenderer, mc.currentScreen.width / 2 - 100 , 50, 200, 20);
		prenom.setFocused(true);
		prenom.setMaxStringLength(200);
		nom = new GuiTextField(2, fontRenderer, mc.currentScreen.width / 2 - 100 , 100, 200, 20);
		nom.setFocused(false);
		nom.setMaxStringLength(200);
		age = new GuiTextField(3, fontRenderer, mc.currentScreen.width / 2 - 100 , 150, 200, 20);
		age.setFocused(false);
		age.setMaxStringLength(2);
		GuiButton butt = new GuiButton(4, mc.currentScreen.width / 2 -100, 200, 200, 20, "Créer personnage.");
		this.buttonList.add(butt);
		super.initGui();
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		prenom.drawTextBox();
		nom.drawTextBox();
		age.drawTextBox();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	 @Override
     protected void keyTyped(char typedChar, int keyCode) throws IOException {
		 if(prenom.isFocused()) {
			 prenom.textboxKeyTyped(typedChar, keyCode);
		 }
		 if(nom.isFocused()) {
			 nom.textboxKeyTyped(typedChar, keyCode);
		 }
		 if(age.isFocused()) {
			 if(Character.isDigit(typedChar) || keyCode == Keyboard.KEY_BACK) {
				 age.textboxKeyTyped(typedChar, keyCode);
			 }
		 }
         super.keyTyped(typedChar, keyCode);
     }

     @Override
     public void updateScreen() {
         super.updateScreen();
         prenom.updateCursorCounter();
         nom.updateCursorCounter();
         age.updateCursorCounter();
     }

     @Override
     protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
         super.mouseClicked(mouseX, mouseY, mouseButton);
         prenom.mouseClicked(mouseX, mouseY, mouseButton);
         nom.mouseClicked(mouseX, mouseY, mouseButton);
         age.mouseClicked(mouseX, mouseY, mouseButton);
     }
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 4) {
			if(prenom.getText().isEmpty() || nom.getText().isEmpty() || age.getText().isEmpty()) return;
			int intage = Integer.parseInt(age.getText());
			WW3Mod.instance.network.sendToServer(new IdFakeMessage(nom.getText(), prenom.getText(), intage));
			System.out.println("yoooooooooooooo");
			mc.player.closeScreen();
		}
	}

}
