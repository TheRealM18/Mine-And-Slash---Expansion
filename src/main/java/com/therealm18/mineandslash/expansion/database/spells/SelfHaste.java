package com.therealm18.mineandslash.expansion.database.spells;

import com.robertx22.mine_and_slash.database.spells.bases.BaseSpell;
import com.robertx22.mine_and_slash.database.spells.bases.EffectCalculation;
import com.robertx22.mine_and_slash.saveclasses.item_classes.SpellItemData;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.localization.CLOC;
import com.therealm18.mineandslash.expansion.database.spells.stats.Haste;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public class SelfHaste extends BaseSpell {

	@Override
	public int BaseValue() {
		return 20;
	}

	@Override
	public Elements Element() {
		return Elements.Nature;
	}

	@Override
	public String GUID() {
		return "spell_self_haste";
	}

	@Override
	public ITextComponent GetDescription(SpellItemData arg0) {
		return CLOC.tooltip("spell_self_haste");
	}

	@Override
	public int ManaCost() {
		return 25;
	}

	@Override
	public EffectCalculation ScalingValue() {
		return new EffectCalculation(new Haste(), 0.75F);
	}

	@Override
	public Item SpellItem() {
		return com.therealm18.mineandslash.expansion.database.items.spells.SelfHaste.ITEM;
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
				caster.addPotionEffect(new EffectInstance(Effects.HASTE, 200, 20));
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
}