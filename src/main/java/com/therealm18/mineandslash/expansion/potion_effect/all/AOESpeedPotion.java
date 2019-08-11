package com.therealm18.mineandslash.expansion.potion_effect.all;

import com.robertx22.mine_and_slash.potion_effects.SpellPotionBase;
import com.therealm18.mineandslash.expansion.Ref;
import com.therealm18.mineandslash.expansion.database.spells.self.SpellSelfSpeed;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectType;
import net.minecraft.util.ResourceLocation;

public class AOESpeedPotion  extends SpellPotionBase {

    public static final AOESpeedPotion INSTANCE = new AOESpeedPotion();

    private AOESpeedPotion() {
        // boolean isBadEffectIn, int liquidColorIn
    	super(EffectType.BENEFICIAL, 4393423);
        this.setRegistryName(new ResourceLocation(Ref.MODID, GUID()));

    }

    public String GUID() {
        return "aoe_speed";
    }

    public void doEffect(Entity applier, Entity caster, LivingEntity target,
                         int amplifier) {

    }
    
    public void performEffectEverySetTime(LivingEntity entity, int amplifier) {

        try {

            if (entity.world.isRemote) {
            } else {
                new SpellSelfSpeed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int performEachXTicks() {
        return 400;
    }

    public String locNameForLangFile() {
        return "Aoe Speed";
    }
}