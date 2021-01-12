package alex.mod1;


import org.apache.logging.log4j.core.Logger;

import alex.mod1.proxy.CommonProxy;
import alex.mod1.util.Reference;
import alex.mod1.util.handlers.RegistryHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION )
public class Main {

	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT , serverSide = Reference.COMMON)
	public static CommonProxy proxy;
	
	public static org.apache.logging.log4j.Logger logger;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent e)
	{
		logger = e.getModLog();
				
		proxy.preInit();
		
		RegistryHandler.preInitRegistries();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent e)
	{
		RegistryHandler.initRegistries();
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent e)
	{
		
	}
	 
	
}
