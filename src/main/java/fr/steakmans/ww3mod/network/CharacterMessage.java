package fr.steakmans.ww3mod.network;

import fr.steakmans.ww3mod.gui.RegisterCharacter;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CharacterMessage implements IMessage {
	
	
	public CharacterMessage() {}

	
	public static class Handler implements IMessageHandler<CharacterMessage, IMessage> {
		
		@SideOnly(Side.CLIENT)
		@Override
		public IMessage onMessage(CharacterMessage message, MessageContext ctx) {
				Minecraft.getMinecraft().displayGuiScreen(new RegisterCharacter());
			return null;
		}
		
	}

	@Override
	public void fromBytes(ByteBuf buf) {
	}

	@Override
	public void toBytes(ByteBuf buf) {
	}
	

}
