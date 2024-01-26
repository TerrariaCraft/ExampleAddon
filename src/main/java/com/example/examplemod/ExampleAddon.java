package com.example.examplemod;

import com.example.examplemod.init.*;
import com.example.examplemod.proxy.CommonProxy;
import com.zeitheron.hammercore.internal.SimpleRegistration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.*;
import org.zeith.terraria.api.crafting.events.RegisterCraftingEvent;
import org.zeith.terraria.api.mod.ITerrariaMod;
import org.zeith.terraria.utils.forge.DeferredRegistries;

@Mod(
		modid = ExampleAddon.MODID,
		name = ExampleAddon.NAME,
		version = ExampleAddon.VERSION,
		dependencies = "required-after:terraria"
)
public class ExampleAddon
		implements ITerrariaMod
{
	public static final Logger LOG = LogManager.getLogger("ExampleAddon");
	
	public static final String MODID = "examplemod";
	public static final String NAME = "Example Mod";
	public static final String VERSION = "1.0";
	
	public final DeferredRegistries registries = new DeferredRegistries(this);
	
	@SidedProxy( // TODO: Update package names whenever you refactor!
			clientSide = "com.example.examplemod.proxy.ClientProxy",
			serverSide = "com.example.examplemod.proxy.CommonProxy",
			modId = MODID
	)
	public static CommonProxy PROXY;
	
	public ExampleAddon()
	{
		// Used to add custom recipes
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@EventHandler
	public void construction(FMLConstructionEvent event)
	{
		// This is very recommended for common addon setup.
		ITerrariaMod.super.constructionEvent(event);
		
		// Pass construction to proxies.
		PROXY.construct();
		
		LOG.info("Constructed.");
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		// TODO: this is going to get drastically changed with TerrariaCraft 12.6.1
		
		// Registers all items
		SimpleRegistration.registerFieldItemsFrom(ItemsEM.class, MODID, null);
		
		// Registers all blocks
		SimpleRegistration.registerFieldBlocksFrom(BlocksEM.class, MODID, null);
	}
	
	@Override
	public DeferredRegistries getRegistries()
	{
		return registries;
	}
	
	@SubscribeEvent
	public void addRecipes(RegisterCraftingEvent e)
	{
		e.addHeavyWorkBenchRecipe(BlocksEM.EXAMPLE_BAR.stack(), BlocksEM.EXAMPLE_BLOCK.stack(4));
	}
	
	// This is left like so intentionally.
	// When compiled, will get replaced by "12.5.1".contains("@VERSION") thus returning FALSE
	@SuppressWarnings("ConstantValue")
	public static final boolean IN_DEV = "@VERSION@".contains("@VERSION");
}