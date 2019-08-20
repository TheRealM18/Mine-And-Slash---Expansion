package com.therealm18.mineandslash.expansion.database.items;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigurateTools {

    public static Common COMMON;

    public static ForgeConfigSpec init(ForgeConfigSpec.Builder builder) {
        COMMON = new Common(builder);
        return builder.build();
    }

    public static class Common {

        public final ForgeConfigSpec.IntValue hammerDuraLossMulti;
        public final ForgeConfigSpec.IntValue excavatorDuraLossMulti;

        public Common(ForgeConfigSpec.Builder builder) {

            builder.comment(" Practical Tools config \n These multipliers affect the amount of damage tools take per use.").push("common");
            hammerDuraLossMulti = builder.defineInRange("HammerDuraLossMulti", 2, 1, Integer.MAX_VALUE);
            excavatorDuraLossMulti = builder.defineInRange("ExcavatorDuraLossMulti", 2, 1, Integer.MAX_VALUE);
            builder.pop();
        }
    }
}