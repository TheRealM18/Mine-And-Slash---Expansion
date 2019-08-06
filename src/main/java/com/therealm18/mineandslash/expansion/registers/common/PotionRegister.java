package com.therealm18.mineandslash.expansion.registers.common;

//import com.robertx22.mine_and_slash.potion_effects.all.BonusDmgPotion;
import com.therealm18.mineandslash.expansion.Ref;
import com.therealm18.mineandslash.expansion.potion_effect.all.AOEHastePotion;

import net.minecraft.potion.Effect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Ref.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PotionRegister {

    @SubscribeEvent
    public static void register(RegistryEvent.Register<Effect> event) {

        IForgeRegistry<Effect> reg = event.getRegistry();

        reg.register(AOEHastePotion.INSTANCE);
//
//        for (BonusDmgPotion pot : BonusDmgPotion.INSTANCE.generateAllPossibleStatVariations()) {
//            reg.register(pot);
//            BonusDmgPotion.MAP.put(pot.element, pot);
//        }

    }

}