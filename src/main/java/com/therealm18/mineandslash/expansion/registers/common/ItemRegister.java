package com.therealm18.mineandslash.expansion.registers.common;

import java.util.ArrayList;
import java.util.List;

import com.robertx22.mine_and_slash.uncommon.interfaces.IGenerated;
import com.therealm18.mineandslash.expansion.Ref;
import com.therealm18.mineandslash.expansion.database.items.spell_items.self.ItemSelfHaste;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Ref.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemRegister {

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

        registerSingles(event);
    }


    private static List<Item> list = new ArrayList<>();

    public static void shcheduleToRegister(Item item) {
        list.add(item);
    }

    private static void registerSingles(RegistryEvent.Register<Item> event) {

        IForgeRegistry<Item> r = event.getRegistry();

        list.add(new ItemSelfHaste());

        for (Item item : list) {
            if (item instanceof IGenerated) {
                IGenerated gen = (IGenerated) item;
                gen.generateAllPossibleStatVariations()
                        .forEach(x -> r.register((Item) x));

            } else {
                r.register(item);
            }

        }

    }

}
