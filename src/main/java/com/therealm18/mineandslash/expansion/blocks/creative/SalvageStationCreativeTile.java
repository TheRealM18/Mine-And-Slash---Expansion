package com.therealm18.mineandslash.expansion.blocks.creative;

import com.robertx22.mine_and_slash.blocks.salvage_station.TileGearSalvage;

public class SalvageStationCreativeTile extends TileGearSalvage{
	
	
    public SalvageStationCreativeTile() {
        super();
        this.ticksRequired();
    }
    @Override
    public int ticksRequired() {
        return 100;
    }
}
