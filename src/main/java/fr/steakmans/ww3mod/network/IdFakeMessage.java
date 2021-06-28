package fr.steakmans.ww3mod.network;

import fr.steakmans.ww3mod.items.ModItems;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class IdFakeMessage implements IMessage {
	
	private static String lastname;
	private static String name;
	private static int age;
	
	public IdFakeMessage() {}
	
	public IdFakeMessage(String lastname, String name, int age) {
		this.lastname = lastname;
		this.name = name;
		this.age = age;
	}

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
	
	public static class Handler implements IMessageHandler<IdFakeMessage, IMessage> {

		@Override
		public IMessage onMessage(IdFakeMessage message, MessageContext ctx) {
				ItemStack stack = ModItems.IDENTITY.getDefaultInstance();
				if(!stack.hasTagCompound()) {
					stack.setTagCompound(new NBTTagCompound());
				}
					stack.getTagCompound().setInteger("age", age);
					stack.getTagCompound().setString("nom", lastname);
					stack.getTagCompound().setString("prenom", name);
					stack.getTagCompound().setBoolean("fake", true);
					ctx.getServerHandler().player.inventory.addItemStackToInventory(stack);
			
			return null;
		}
		
	}

}
