package com.therealm18.mineandslash.expansion.database.stats.stat_types;

import com.robertx22.mine_and_slash.database.stats.Stat;
import com.robertx22.mine_and_slash.saveclasses.Unit;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;

import net.minecraft.entity.LivingEntity;

public class Breath  extends Stat {
    public static String GUID = "Breath";

    @Override
    public int iconSpriteNumber() {
        return 1;
    }

    @Override
    public StatGroup statGroup() {
        return StatGroup.Main;
    }

    @Override
    public String locDescForLangFile() {
        return "Allows you to breath longer.";
    }

    public Breath() {
    }

    @Override
    public String GUID() {
        return GUID;
    }

    @Override
    public boolean ScalesToLevel() {
        return true;
    }

    @Override
    public Elements Element() {
        return null;
    }

    @Override
    public boolean IsPercent() {
        return false;
    }

    public int CurrentValue(LivingEntity entity, Unit unit) {

        float mult = entity.prevLimbSwingAmount / entity.limbSwingAmount;

        return (int) (mult * unit.healthData().Value);

    }

    @Override
    public String locNameForLangFile() {
        return "Breath";
    }
}