package fr.steakmans.ww3mod.proxy;

import java.io.File;

import fr.steakmans.ww3mod.WW3Mod;
import fr.steakmans.ww3mod.commands.CharacterCommand;
import fr.steakmans.ww3mod.network.CharacterMessage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class ServerProxy extends CommonProxy {

	@Override
	public void preInit(File configFile) {
		super.preInit(configFile);
	}

	@Override
	public void init() {
		WW3Mod.instance.mysql.connect("localhost", 3306, "ww3", "scandium", "x65rnL71");
		super.init();
	}

}
