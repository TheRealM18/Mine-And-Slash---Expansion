package com.therealm18.mineandslash.expansion;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.robertx22.mine_and_slash.mmorpg.RegisterEvents;
import com.robertx22.mine_and_slash.mmorpg.registers.common.ConfigRegister;
import com.robertx22.mine_and_slash.onevent.world.OnStartResetMaps;
import com.therealm18.mineandslash.expansion.db_lists.registry.ExpansionRegistry;

@Mod("mineandslashexpansion")
@EventBusSubscriber
public class MASE
{
    private static final Logger LOGGER = LogManager.getLogger();

    public MASE() {

        System.out.println("Starting Mine and Slash - Expansion");

        RegisterEvents.register();

        ConfigRegister.register(); // MUST BE IN MAIN CLASS
        ConfigRegister.load();  // MUST BE IN MAIN CLASS

        OnStartResetMaps.OnStartResetMaps();

        ExpansionRegistry.init(); // after config registerAll

//        StructurePieceRegisters.reg();
    }
    
    @SubscribeEvent
    public static void onServerStarting(FMLServerStartingEvent event) {
//        CommandRegister.Register(event.getServer());
//        ConfigRegister.regAndLoadNonForgeConfigs();

//        if (RUN_DEV_TOOLS) { // CHANGE ON PUBLIC BUILDS TO FALSE
//            TestManager.RunAllTests();
//            CreateLangFile.create();
//            GenerateCurioDataJsons.generate();
//
//        }

    }

}
