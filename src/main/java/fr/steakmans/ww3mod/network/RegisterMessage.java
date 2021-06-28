package fr.steakmans.ww3mod.network;

import fr.steakmans.ww3mod.WW3Mod;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class RegisterMessage implements IMessage {
	
	public static class Handler implements IMessageHandler<RegisterMessage, IMessage> {

		@Override
		public IMessage onMessage(RegisterMessage message, MessageContext ctx) {
			WW3Mod.instance.Charact.insert(ctx.getServerHandler().player.getUniqueID(), lastname, name, age);
			return null;
		}
		
	}
	
	private static String lastname;
	private static String name;
	private static int age;

	@Override
	public void fromBytes(ByteBuf buf) {
		lastname = ByteBufUtils.readUTF8String(buf);
		name = ByteBufUtils.readUTF8String(buf);
		age = buf.readInt();		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, lastname);
		ByteBufUtils.writeUTF8String(buf, name);
		buf.writeInt(age);		
	}
	
	public RegisterMessage() {}
	
	public RegisterMessage(String name, String lastname, int age) {
		this.name = name;
		this.lastname = lastname;
		this.age = age;
	}

}
