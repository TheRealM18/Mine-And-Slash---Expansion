package com.therealm18.mineandslash.expansion.utils;

import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class Tags {

  public static class Blocks {
    public static final Tag<Block> SHULKERS = tag("shulkers");
    public static final Tag<Block> COMMON_SHULKERS = tag("shulkers/common");
    public static final Tag<Block> UNCOMMON_SHULKERS = tag("shulkers/uncommon");
    public static final Tag<Block> RARE_SHULKERS = tag("shulkers/rare");
    public static final Tag<Block> EPIC_SHULKERS = tag("shulkers/epic");
    public static final Tag<Block> LEGENDARY_SHULKERS = tag("shulkers/legendary");

    private static Tag<Block> tag(String name) {
      return new BlockTags.Wrapper(new ResourceLocation("forge", name));
    }
  }
}
