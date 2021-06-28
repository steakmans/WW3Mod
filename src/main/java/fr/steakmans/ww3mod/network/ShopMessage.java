package fr.steakmans.ww3mod.network;

import fr.steakmans.ww3mod.items.ModItems;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ShopMessage implements IMessage {
	
	public static class Handler implements IMessageHandler<ShopMessage, IMessage> {

		@Override
		public IMessage onMessage(ShopMessage message, MessageContext ctx) {
			ctx.getServerHandler().player.sendMessage(new TextComponentString(message.text));
			return null;
		}
		
	}
	
	private String text;
	
	//important
	public ShopMessage() {}
	
	public ShopMessage(String text) {
		this.text = text;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		text = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, text);
	}

}