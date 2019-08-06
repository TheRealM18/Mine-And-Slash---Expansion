package com.therealm18.mineandslash.expansion.database.spells.self.haste;

import com.robertx22.mine_and_slash.database.spells.bases.EffectCalculation;
import com.robertx22.mine_and_slash.database.spells.bases.SpellBuffCheck;
import com.robertx22.mine_and_slash.saveclasses.item_classes.SpellItemData;
import com.robertx22.mine_and_slash.uncommon.capability.EntityCap.UnitData;
import com.robertx22.mine_and_slash.uncommon.datasaving.Load;
import com.robertx22.mine_and_slash.uncommon.effectdatas.SpellBuffEffect;
import com.robertx22.mine_and_slash.uncommon.localization.CLOC;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.ParticleUtils;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.SoundUtils;
import com.therealm18.mineandslash.expansion.database.items.spell_items.self.ItemSelfHaste;
import com.therealm18.mineandslash.expansion.database.stats.stat_types.Haste;
import com.therealm18.mineandslash.expansion.potion_effect.all.AOEHastePotion;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public class SpellSelfHaste extends BaseSpellHaste {
	
    @Override
    public int useTimeTicks() {
        return 20;
    }

    @Override
    public String GUID() {
        return "spell_self_haste";
    }

    @Override
    public int ManaCost() {
        return 25;
    }

    @Override
    public int BaseValue() {
        return 5;
    }

    @Override
    public EffectCalculation ScalingValue() {
        return new EffectCalculation(new Haste(), 0.75F);

    }

    @Override
    public Item SpellItem() {
        return ItemSelfHaste.ITEM;
    }

    @Override
    public ITextComponent GetDescription(SpellItemData data) {
        return CLOC.tooltip("spell_self_haste");
    }
    
    @Override
    public boolean cast(World world, PlayerEntity caster, Hand hand, int ticksInUse,
                        SpellItemData data) {
        try {

            if (!world.isRemote) {

                SoundUtils.playSoundAtPlayer(caster, SoundEvents.ENTITY_GENERIC_DRINK, 1, 1);

                UnitData unit = Load.Unit(caster);

                int healed = (int) (data.GetBaseValue() + data.GetScalingValue() * unit.getUnit()
                        .healthData().Value / 100);

                caster.addPotionEffect(new EffectInstance(AOEHastePotion.INSTANCE, 400, healed));

                // spell buffs
                SpellBuffCheck check = new SpellBuffCheck(this.Type());
                SpellBuffEffect spelleffect = new SpellBuffEffect(caster, check);
                spelleffect.Activate();
                checkSpellBuffs(caster, check);
                //

            } else {

                ParticleUtils.spawnHealParticles(caster, 10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
}
