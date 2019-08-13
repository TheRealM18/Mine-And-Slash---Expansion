package com.therealm18.mineandslash.expansion.blocks.chest.master_chest;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.robertx22.mine_and_slash.items.bags.master_bag.ContainerMasterBag;
import com.robertx22.mine_and_slash.items.bags.master_bag.ContainerMasterBag.ItemType;
import com.robertx22.mine_and_slash.items.bags.master_bag.NamedMasterBag;
import com.robertx22.mine_and_slash.uncommon.capability.MasterLootBagCap;
import com.robertx22.mine_and_slash.uncommon.capability.MasterLootBagCap.IMasterLootBagData;
import com.robertx22.mine_and_slash.uncommon.interfaces.IAutoLocName;
import com.robertx22.mine_and_slash.uncommon.item_filters.bases.ItemFilterGroup;
import com.robertx22.mine_and_slash.uncommon.localization.CLOC;
import com.therealm18.mineandslash.expansion.Ref;
import com.therealm18.mineandslash.expansion.registry.BlockReferance;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.IItemHandler;

public class MasterChestTile extends ChestTileEntity implements IAutoLocName {

    public static final String ID = Ref.MODID + ":master_chest";
    public int size = 9 * 6;

    public MasterChestTile() {
        super();

        this.size  *= ContainerMasterBag.ItemType.values().length;

    }

    public IItemHandler getInventory(ItemStack bag, ItemStack stack) {

        if (stack.getCount() > 0 && filterGroup().anyMatchesFilter(stack)) {
            IMasterLootBagData capa = bag.getCapability(MasterLootBagCap.Data)
                    .orElse(null);

            if (capa != null) {
            	ItemType type = getItemType(stack);

                return capa.getInventory(type);
            }
        }
        return null;

    }

    public static ContainerMasterBag.ItemType getItemType(ItemStack stack) {

        for (ContainerMasterBag.ItemType type : ContainerMasterBag.ItemType.values()) {
//            if (type.filter.anyMatchesFilter(stack)) {
                return type;
//            }
        }
        return ContainerMasterBag.ItemType.GEAR;

    }

    @Nonnull
    public ActionResult<ItemStack> onRightClick(World world, PlayerEntity player,
                                                    @Nonnull Hand hand) {

        if (!world.isRemote) {
                NetworkHooks.openGui((ServerPlayerEntity) player, getNamedContainer(new ItemStack (BlockReferance.BLOCK_MASTER_CHEST, 1)), extraData -> {
                    extraData.writeString(ContainerMasterBag.ItemType.GEAR.toString());
                });
        }

        return ActionResult.newResult(ActionResultType.SUCCESS, player.getHeldItemMainhand());
    }

    public ItemFilterGroup filterGroup() {
        return ItemFilterGroup.ANY_MASTER_BAG;
    }

    public INamedContainerProvider getNamedContainer(ItemStack stack) {
        return new NamedMasterBag(stack, ContainerMasterBag.ItemType.GEAR);
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
		return new ContainerMasterBag(num, inventory, player);
	}
}