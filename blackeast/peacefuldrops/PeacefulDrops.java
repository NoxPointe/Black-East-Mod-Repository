package com.blackeast.peacefuldrops;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid="PeacefulDrops", name="Black East Peaceful Drops", version="0.0.3")

public class PeacefulDrops {
	
	// The instance of your mod that Forge uses.
    @Instance(value = "PeacefulDrops")
    public static PeacefulDrops instance;
    
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="com.blackeast.peacefuldrops.client.ClientProxy", 
    		serverSide="com.blackeast.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	GameRegistry.addRecipe(new ItemStack(Items.blaze_rod), "x", "y", "x", 
    			'x', new ItemStack(Items.iron_ingot),
    			'y', new ItemStack(Items.lava_bucket));
    	
    	GameRegistry.addRecipe(new ItemStack(Items.nether_star), "xyx", "yzy", "xyx",
    			'x', new ItemStack(Items.netherbrick),
    			'y', new ItemStack(Items.quartz),
    			'z', new ItemStack(Items.glowstone_dust));
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event) {
            proxy.registerRenderers();
            
            MinecraftForge.EVENT_BUS.register(new PeacefulDropsEvents());
             
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    }

}
