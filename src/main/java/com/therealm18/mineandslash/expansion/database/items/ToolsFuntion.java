package com.therealm18.mineandslash.expansion.database.items;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.*;
import net.minecraft.world.World;

import java.util.Random;
import java.util.Set;

public class ToolsFuntion {

    public static final Random random = new Random();

    public static void attemptBreakNeighbors(World world,
                                             BlockPos pos,
                                             PlayerEntity player,
                                             Set<Block> effectiveOn,
                                             Set<Material> effectiveMaterials,
                                             boolean checkHarvestLevel) {

        world.setBlockState(pos, Blocks.GLASS.getDefaultState());
        RayTraceResult trace = calcRayTrace(world, player, RayTraceContext.FluidMode.ANY);
        world.setBlockState(pos, Blocks.AIR.getDefaultState());

        if (trace.getType() == RayTraceResult.Type.BLOCK) {
            BlockRayTraceResult blockTrace = (BlockRayTraceResult) trace;
            Direction face = blockTrace.getFace();

            int fortuneLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, player.getHeldItemMainhand());
            int silkLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, player.getHeldItemMainhand());

            for (int a = -1; a <= 1; a++) {
                for (int b = -1; b <= 1; b++) {
                    if (a == 0 && b == 0) continue;

                    BlockPos target = null;

                    if (face == Direction.UP    || face == Direction.DOWN)  target = pos.add(a, 0, b);
                    if (face == Direction.NORTH || face == Direction.SOUTH) target = pos.add(a, b, 0);
                    if (face == Direction.EAST  || face == Direction.WEST)  target = pos.add(0, a, b);

                    attemptBreak(world, target, player, effectiveOn, effectiveMaterials, fortuneLevel, silkLevel, checkHarvestLevel);
                }
            }
        }
    }

    public static void attemptBreak(World world,
                                    BlockPos pos,
                                    PlayerEntity player,
                                    Set<Block> effectiveOn,
                                    Set<Material> effectiveMaterials,
                                    int fortuneLevel,
                                    int silkLevel,
                                    boolean checkHarvestLevel) {
        BlockState state = world.getBlockState(pos);

        boolean validHarvest = !checkHarvestLevel || player.getHeldItemMainhand().canHarvestBlock(state);
        boolean isEffective = effectiveOn.contains(state.getBlock()) || effectiveMaterials.contains(state.getMaterial());
        boolean witherImmune = BlockTags.WITHER_IMMUNE.contains(state.getBlock());

        if (validHarvest && isEffective && !witherImmune) {
            world.destroyBlock(pos, false);
            Block.spawnDrops(state, world, pos, null, player, player.getHeldItemMainhand());

            int exp = state.getExpDrop(world, pos, fortuneLevel, silkLevel);
            if (exp > 0) {
                state.getBlock().dropXpOnBlockBreak(world, pos, exp);
            }
        }
    }

    public static RayTraceResult calcRayTrace(World worldIn, PlayerEntity player, RayTraceContext.FluidMode fluidMode) {
        float f = player.rotationPitch;
        float f1 = player.rotationYaw;
        Vec3d vec3d = player.getEyePosition(1.0F);
        float f2 = MathHelper.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f3 = MathHelper.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f4 = MathHelper.cos(-f * ((float)Math.PI / 180F));
        float f5 = MathHelper.sin(-f * ((float)Math.PI / 180F));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        double d0 = player.getAttribute(PlayerEntity.REACH_DISTANCE).getValue();;
        Vec3d vec3d1 = vec3d.add((double)f6 * d0, (double)f5 * d0, (double)f7 * d0);
        return worldIn.rayTraceBlocks(new RayTraceContext(vec3d, vec3d1, RayTraceContext.BlockMode.OUTLINE, fluidMode, player));
    }
}