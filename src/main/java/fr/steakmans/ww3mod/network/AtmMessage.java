package fr.steakmans.ww3mod.network;

import fr.steakmans.ww3mod.WW3Mod;
import fr.steakmans.ww3mod.items.ModItems;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import scala.collection.TraversableOnce.MonadOps;

public class AtmMessage implements IMessage {
	
	public static class Handler implements IMessageHandler<AtmMessage, IMessage> {

		@Override
		public IMessage onMessage(AtmMessage message, MessageContext ctx) {
			int montant = Integer.parseInt(message.text);
			int retirer = montant;
			long money = WW3Mod.instance.money.getMoney(ctx.getServerHandler().player.getUniqueID());
			if(money >= montant) {
			try {
				int CINQCENTS = 0;
				int DEUXCENTS= 0;
				int CENTS= 0;
				int CINQUANTE= 0;
				int VINGTS= 0;
				int DIX= 0;
				int CINQ= 0;
				int DEUX= 0;
				int UN= 0;
				while (montant >= 1) {
					if(montant >= 500) {
						CINQCENTS += 1;
						montant -= 500;
					} else if (montant >= 200) {
						DEUXCENTS += 1;
						montant -= 200;
					} else if (montant >= 100) {
						CENTS += 1;
						montant -= 100;
					} else if (montant >= 50) {
						CINQUANTE += 1;
						montant -= 50;
					} else if (montant >= 20) {
						VINGTS += 1;
						montant -= 20;
					} else if (montant >= 10) {
						DIX += 1;
						montant -= 10;
					} else if (montant >= 5) {
						CINQ += 1;
						montant -= 5;
					} else if (montant >= 2) {
						DEUX += 1;
						montant -= 2;
					} else if (montant >= 1) {
						UN += 1;
						montant -= 1;
					}
				}
				WW3Mod.instance.money.add(ctx.getServerHandler().player.getUniqueID(), -retirer);
				for(int i = 0; CINQCENTS > 0; CINQCENTS--) {
					ItemStack item = new ItemStack(ModItems.BILLET_500);
					ctx.getServerHandler().player.inventory.addItemStackToInventory(item);
				}
				for(int i = 0; DEUXCENTS > 0; DEUXCENTS--) {
					ItemStack item = new ItemStack(ModItems.BILLET_200);
					ctx.getServerHandler().player.inventory.addItemStackToInventory(item);
				}
				for(int i = 0; CENTS > 0; CENTS--) {
					ItemStack item = new ItemStack(ModItems.BILLET_100);
					ctx.getServerHandler().player.inventory.addItemStackToInventory(item);
				}
				for(int i = 0; CINQUANTE > 0; CINQUANTE--) {
					ItemStack item = new ItemStack(ModItems.BILLET_50);
					ctx.getServerHandler().player.inventory.addItemStackToInventory(item);
				}
				for(int i = 0; VINGTS > 0; VINGTS--) {
					ItemStack item = new ItemStack(ModItems.BILLET_20);
					ctx.getServerHandler().player.inventory.addItemStackToInventory(item);
				}
				for(int i = 0; DIX > 0; DIX--) {
					ItemStack item = new ItemStack(ModItems.BILLET_10);
					ctx.getServerHandler().player.inventory.addItemStackToInventory(item);
				}
				for(int i = 0; CINQ > 0; CINQ--) {
					ItemStack item = new ItemStack(ModItems.BILLET_5);
					ctx.getServerHandler().player.inventory.addItemStackToInventory(item);
				}
				for(int i = 0; DEUX > 0; DEUX--) {
					ItemStack item = new ItemStack(ModItems.BILLET_2);
					ctx.getServerHandler().player.inventory.addItemStackToInventory(item);
				}
				for(int i = 0; UN > 0; UN--) {
					ItemStack item = new ItemStack(ModItems.BILLET_1);
					ctx.getServerHandler().player.inventory.addItemStackToInventory(item);
				}
			} catch (NumberFormatException e) {
				ctx.getServerHandler().player.sendMessage(new TextComponentString("failed"));
			}
			} else {
				ctx.getServerHandler().player.sendMessage(new TextComponentString("§4Tu n'as pas assez d'argent! La banque n'autorise pas le découvert."));
			}
			return null;
		}
		
	}
	
	private String text;
	
	//important
	public AtmMessage() {}
	
	public AtmMessage(String text) {
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
