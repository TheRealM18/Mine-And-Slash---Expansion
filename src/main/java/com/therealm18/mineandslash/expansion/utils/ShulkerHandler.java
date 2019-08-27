package com.therealm18.mineandslash.expansion.utils;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.items.ItemStackHandler;

import java.util.List;

public class ShulkerHandler extends ItemStackHandler {

  public TileEntity tileEntity;

  public ShulkerHandler(int size, TileEntity tileEntity){
    super(size);
    this.tileEntity = tileEntity;
  }
  @Override
  protected void onContentsChanged(int slot)
  {
    this.tileEntity.markDirty();
  }

  public List<ItemStack> getContents(){
    return this.stacks;
  }

  public void setContents(List<ItemStack> oldContents, int newSize){
      this.setSize(newSize);
      for (int i = 0; i < oldContents.size(); i++) {
        this.getContents().set(i, oldContents.get(i));
      }
    }
  }

