package com.therealm18.mineandslash.expansion.potion_effect.all;

import com.robertx22.mine_and_slash.potion_effects.SpellPotionBase;
import com.robertx22.mine_and_slash.uncommon.capability.EntityCap.UnitData;
import com.robertx22.mine_and_slash.uncommon.datasaving.Load;
import com.robertx22.mine_and_slash.uncommon.effectdatas.HealData;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.ParticleUtils;
import com.therealm18.mineandslash.expansion.Ref;
import com.therealm18.mineandslash.expansion.database.spells.self.speed.SpellSelfSpeed;

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

    @Override
    public String GUID() {
        return "aoe_speed";
    }

    @Override
    public void doEffect(Entity applier, Entity caster, LivingEntity target,
                         int amplifier) {

    }
    
    @Override
    public void performEffectEverySetTime(LivingEntity entity, int amplifier) {

        try {

            if (entity.world.isRemote) {
                ParticleUtils.spawnHealParticles(entity, 3);
            } else {
                UnitData data = Load.Unit(entity);

                data.heal(new HealData(entity, data, amplifier).bySpell(new SpellSelfSpeed()));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int performEachXTicks() {
        return 400;
    }

    @Override
    public String locNameForLangFile() {
        return "Aoe Speed";
    }
}