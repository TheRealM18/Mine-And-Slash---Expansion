package com.therealm18.mineandslash.expansion.blocks.chest.master_chest;

import com.robertx22.mine_and_slash.blocks.bases.BaseInventoryBlock;
import com.robertx22.mine_and_slash.uncommon.interfaces.IAutoLocName;
import com.robertx22.mine_and_slash.uncommon.item_filters.bases.ItemFilterGroup;
import com.therealm18.mineandslash.expansion.Ref;
import com.therealm18.mineandslash.expansion.registry.BlockReferance;
import com.therealm18.mineandslash.expansion.uncommon.capability.MasterLootBlockCap;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.registries.ObjectHolder;

public class MasterChestBlock  extends BaseInventoryBlock implements IAutoLocName {

    public static final String ID = Ref.MODID + ":master_chest";
	private int size;

    @ObjectHolder(ID)
    public static final Block BLOCK = null;
	
    public MasterChestBlock() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(5F));

        this.size *= MasterChestContainer.ItemType.values().length;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {

        return new MasterChestTile();

    }
    public IItemHandler getInventory(ItemStack bag, ItemStack stack) {

        if (stack.getCount() > 0 && filterGroup().anyMatchesFilter(stack)) {
            MasterLootBlockCap.IMasterLootChestData capa = bag.getCapability(MasterLootBlockCap.Data)
                    .orElse(null);

            if (capa != null) {
            	MasterChestContainer.ItemType type = getItemType(stack);

                return capa.getInventory(type);
            }
        }
        return null;

    }

    public static MasterChestContainer.ItemType getItemType(ItemStack stack) {

        for (MasterChestContainer.ItemType type : MasterChestContainer.ItemType.values()) {
            if (type.filter.anyMatchesFilter(stack)) {
                return type;
            }
        }
        return MasterChestContainer.ItemType.GEAR;

    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
       if (worldIn.isRemote) {
          return true;
       } else {
    	   INamedContainerProvider NamedMasterChest = getNamedContainer(new ItemStack(BlockReferance.BLOCK_MASTER_CHEST, 1));
          if (NamedMasterChest != null) {
             player.openContainer(NamedMasterChest);
          }

          return true;
       }
    }

	public ItemFilterGroup filterGroup() {
        return ItemFilterGroup.ANY_MASTER_BAG;
    }

    public INamedContainerProvider getNamedContainer(ItemStack stack) {
        return new NamedMasterChest(stack, MasterChestContainer.ItemType.GEAR);
    }

    @Override
    public AutoLocGroup locNameGroup() {
        return AutoLocGroup.Misc;
    }

    @Override
    public String locNameLangFileGUID() {
        return this.getRegistryName().toString();
    }

    @Override
    public String locNameForLangFile() {
        return TextFormatting.YELLOW + "Master Chest";
    }

    @Override
    public String GUID() {
        return "master_chest";
    }

}