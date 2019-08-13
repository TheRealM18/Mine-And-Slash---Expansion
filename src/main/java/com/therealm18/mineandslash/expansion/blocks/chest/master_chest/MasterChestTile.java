package com.therealm18.mineandslash.expansion.blocks.chest.master_chest;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.robertx22.mine_and_slash.uncommon.interfaces.IBaseAutoLoc.AutoLocGroup;
import com.robertx22.mine_and_slash.uncommon.item_filters.bases.ItemFilterGroup;
import com.robertx22.mine_and_slash.uncommon.localization.CLOC;
import com.therealm18.mineandslash.expansion.Ref;
import com.therealm18.mineandslash.expansion.registry.BlockReferance;
import com.therealm18.mineandslash.expansion.uncommon.capability.MasterLootBlockCap;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.IItemHandler;

public class MasterChestTile extends TileEntity implements INamedContainerProvider {

    public static final String ID = Ref.MODID + ":master_chest";

	private int size;

    public MasterChestTile() {
        super(BlockReferance.TILE_MASTER_CHEST);

        size  *= MasterChestContainer.ItemType.values().length;

    }

    public IItemHandler getInventory(ItemStack bag, ItemStack stack) {

        if (stack.getCount() > 0 && filterGroup().anyMatchesFilter(stack)) {
            MasterLootBlockCap.IMasterLootBagData capa = bag.getCapability(MasterLootBlockCap.Data)
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

    @Nonnull
    public ActionResult<ItemStack> onRightClick(World world, PlayerEntity player,
                                                    @Nonnull Hand hand) {

        if (!world.isRemote) {
                NetworkHooks.openGui((ServerPlayerEntity) player, getNamedContainer(new ItemStack (BlockReferance.BLOCK_MASTER_CHEST, 1)), extraData -> {
                    extraData.writeString(MasterChestContainer.ItemType.GEAR.toString());
                });
        }

        return ActionResult.newResult(ActionResultType.SUCCESS, player.getHeldItemMainhand());
    }

    public ItemFilterGroup filterGroup() {
        return ItemFilterGroup.ANY_MASTER_BAG;
    }

    public INamedContainerProvider getNamedContainer(ItemStack stack) {
        return new NamedMasterChest(stack, MasterChestContainer.ItemType.GEAR);
    }

    public AutoLocGroup locNameGroup() {
        return AutoLocGroup.Misc;
    }

    public String locNameLangFileGUID() {
        return TextFormatting.YELLOW + "Master Chest";
    }

    public String locNameForLangFile() {
        return TextFormatting.YELLOW + "Master Chest";
    }

    public String GUID() {
        return "master_chest";
    }

    @Override
    public ITextComponent getDisplayName() {
        return CLOC.blank("block.mineandslashexpansion.masterchest");
    }

    @Nullable
	public Container createMenu(int num, PlayerInventory inventory, PacketBuffer player) {
		return new MasterChestContainer(num, inventory, player);
	}

	@Override
	public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
		// TODO Auto-generated method stub
		return null;
	}
}