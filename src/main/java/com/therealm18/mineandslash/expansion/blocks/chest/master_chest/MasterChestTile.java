package com.therealm18.mineandslash.expansion.blocks.chest.master_chest;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.robertx22.mine_and_slash.uncommon.interfaces.IAutoLocName;
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
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class MasterChestTile extends TileEntity implements IAutoLocName {

    public static final String ID = Ref.MODID + ":master_chest";
    public int size = 9 * 6;

    public MasterChestTile() {
        super(BlockReferance.TILE_MASTER_CHEST);

        this.size  *= MasterChestContainer.ItemType.values().length;

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

    public ITextComponent getDisplayName() {
        return CLOC.blank("block.mineandslashexpansion.masterchest");
    }

    @Nullable
	public Container createMenu(int num, PlayerInventory inventory, PacketBuffer player) {
		return new MasterChestContainer(num, inventory, player);
	}

    @Nonnull
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT oldCapNbt) {
        return new InvProvider(size);
    }

    public static class InvProvider implements ICapabilitySerializable<INBT> {

        int size;

        public InvProvider(int size) {
            this.size = size;
            inv = new ItemStackHandler(size);
            opt = LazyOptional.of(() -> inv);
        }

        private final IItemHandler inv;
        private final LazyOptional<IItemHandler> opt;

        @Nonnull
        @Override
        public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
            if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
                return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.orEmpty(cap, opt);
            }
            return LazyOptional.empty();
        }

        @Override
        public INBT serializeNBT() {
            return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.writeNBT(inv, null);
        }

        @Override
        public void deserializeNBT(INBT nbt) {
            CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.readNBT(inv, null, nbt);

        }

    }
}