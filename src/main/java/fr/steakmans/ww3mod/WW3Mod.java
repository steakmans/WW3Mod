package fr.steakmans.ww3mod;

import org.apache.logging.log4j.Logger;

import fr.steakmans.ww3mod.commands.CharacterCommand;
import fr.steakmans.ww3mod.commands.FakeIdentityCardCommand;
import fr.steakmans.ww3mod.commands.IdentityCardCommand;
import fr.steakmans.ww3mod.items.ModItems;
import fr.steakmans.ww3mod.mysql.CharacterManager;
import fr.steakmans.ww3mod.mysql.MoneyManager;
import fr.steakmans.ww3mod.mysql.Mysql;
import fr.steakmans.ww3mod.network.AtmMessage;
import fr.steakmans.ww3mod.network.CharacterMessage;
import fr.steakmans.ww3mod.network.IdFakeMessage;
import fr.steakmans.ww3mod.network.IdMessage;
import fr.steakmans.ww3mod.network.RegisterMessage;
import fr.steakmans.ww3mod.network.ShopMessage;
import fr.steakmans.ww3mod.proxy.ClientProxy;
import fr.steakmans.ww3mod.proxy.CommonProxy;
import fr.steakmans.ww3mod.proxy.ServerProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.CustomPacketEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.server.permission.DefaultPermissionLevel;
import net.minecraftforge.server.permission.PermissionAPI;

@Mod(modid = WW3Mod.MODID, name = "WW3 Mod", version = "1.0", acceptedMinecraftVersions = "[1.12.2]")
public class WW3Mod {
	
	public Mysql mysql = new Mysql();
	public MoneyManager money = new MoneyManager();
	public CharacterManager Charact = new CharacterManager();
	
	public static final String MODID = "ww3mod";
	public static CreativeTabs DivisionTab = new CreativeTabs("division_tab")
	{
	    @Override
	    public ItemStack getTabIconItem()
	    {
	        return new ItemStack(ModItems.PHONE1);
	    }
	};
	public static SimpleNetworkWrapper network;	
	
   @Instance(WW3Mod.MODID)
   public static WW3Mod instance;
   
   public static Logger logger;
   
   @EventHandler
   public void preInit(FMLPreInitializationEvent event)
   {
       logger = event.getModLog();
       proxy.preInit(event.getSuggestedConfigurationFile());
       network = NetworkRegistry.INSTANCE.newSimpleChannel(WW3Mod.MODID);
       network.registerMessage(ShopMessage.Handler.class, ShopMessage.class, 0, Side.SERVER);
       network.registerMessage(IdMessage.Handler.class, IdMessage.class, 1, Side.SERVER);
       network.registerMessage(AtmMessage.Handler.class, AtmMessage.class, 2, Side.SERVER);
       network.registerMessage(CharacterMessage.Handler.class, CharacterMessage.class, 3, Side.CLIENT);
       network.registerMessage(IdFakeMessage.Handler.class, IdFakeMessage.class, 4, Side.SERVER);
       network.registerMessage(RegisterMessage.Handler.class, RegisterMessage.class, 5, Side.SERVER);
   }

   @EventHandler
   public void init(FMLInitializationEvent event)
   {
	   proxy.init();
	   
   }
   
   @SidedProxy(clientSide = "fr.steakmans.ww3mod.proxy.ClientProxy", serverSide = "fr.steakmans.ww3mod.proxy.ServerProxy")
   public static CommonProxy proxy;
   
   public WW3Mod() {
	    MinecraftForge.EVENT_BUS.register(new RegisteringHandler());
	    MinecraftForge.EVENT_BUS.register(new ClientProxy());
	    MinecraftForge.EVENT_BUS.register(new ServerProxy());
	    MinecraftForge.EVENT_BUS.register(new CommonProxy());
	}
   
	@EventHandler
	public void onServerStarting(FMLServerStartingEvent event) {
	    event.registerServerCommand(new CharacterCommand());
	    event.registerServerCommand(new IdentityCardCommand());
	    event.registerServerCommand(new FakeIdentityCardCommand());
	}
	
}
