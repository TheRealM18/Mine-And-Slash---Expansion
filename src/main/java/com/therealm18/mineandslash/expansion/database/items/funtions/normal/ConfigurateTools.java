package com.therealm18.mineandslash.expansion.database.items.funtions.normal;

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

            hammerDuraLossMulti = builder.defineInRange("HammerDuraLossMulti", 2, 1, Integer.MAX_VALUE);
            excavatorDuraLossMulti = builder.defineInRange("ExcavatorDuraLossMulti", 2, 1, Integer.MAX_VALUE);
            builder.pop();
        }
    }
}