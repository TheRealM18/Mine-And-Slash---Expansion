package com.therealm18.mineandslash.expansion.database.spells.self;

import com.robertx22.mine_and_slash.database.spells.bases.BaseSpell;
import com.robertx22.mine_and_slash.database.spells.bases.EffectCalculation;
import com.robertx22.mine_and_slash.saveclasses.item_classes.SpellItemData;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.localization.CLOC;
import com.therealm18.mineandslash.expansion.database.items.spell_items.self.ItemSelfSpeed;
import com.therealm18.mineandslash.expansion.database.stats.stat_types.Speed;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public class SpellSelfSpeed extends BaseSpell {

	@Override
	public int BaseValue() {
		return 10;
	}

	@Override
	public Elements Element() {
		return Elements.Nature;
	}

	@Override
	public String GUID() {
		return "spell_self_speed";
	}

	@Override
	public ITextComponent GetDescription(SpellItemData arg0) {
		return CLOC.tooltip("spell_self_speed");
	}

	@Override
	public int ManaCost() {
		return 10;
	}

	@Override
	public EffectCalculation ScalingValue() {
		return new EffectCalculation(new Speed(), 0.75F);
	}

	@Override
	public Item SpellItem() {
		return ItemSelfSpeed.ITEM;
	}

	@Override
	public SpellType Type() {
		return SpellType.Self_Heal;
	}

	@Override
	public boolean cast(World world, PlayerEntity caster, Hand hand, int ticksInUse, SpellItemData data) {
		try {
			if(!world.isRemote) {
				caster.playSound(SoundEvents.ENTITY_GENERIC_DRINK, 1, 1);
				caster.addPotionEffect(new EffectInstance(Effects.SPEED, 200, 10));
			} else {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int useTimeTicks() {
		return 20;
	}

//    public void checkZephyrSpeedBoost(PlayerEntity caster, SpellBuffCheck buffable) {
//
//        if (buffable.getBuff().equals(SpellBuffType.Zephyr_Speed_Boost)) {
//            caster.addPotionEffect(new EffectInstance(Effects.SPEED, 200));
//        }
//
//    }
//
//    public void checkPurityRemoveNegativeEffect(PlayerEntity caster,
//                                                SpellBuffCheck buffable) {
//
//        if (buffable.getBuff().equals(SpellBuffType.Purity_Remove_Negative_Effects)) {
//            for (EffectInstance pot : new ArrayList<EffectInstance>(caster.getActivePotionEffects())) {
//                if (pot.getPotion().isBeneficial() == false) {
//                    caster.removePotionEffect(pot.getPotion());
//                    break;
//                }
//            }
//        }
//
//    }
//
//    public void checkAddLightBuff(PlayerEntity caster, SpellBuffCheck buffable) {
//        if (buffable.getBuff().equals(SpellBuffType.Light_Aoe_Regen)) {
//            caster.addPotionEffect(new EffectInstance(Effects.SPEED, 200, 10));
//        }
//
//    }
//
//    public void checkSpellBuffs(PlayerEntity caster, SpellBuffCheck buffable) {
//        checkZephyrSpeedBoost(caster, buffable);
//        checkAddLightBuff(caster, buffable);
//        checkPurityRemoveNegativeEffect(caster, buffable);
//    }

}
