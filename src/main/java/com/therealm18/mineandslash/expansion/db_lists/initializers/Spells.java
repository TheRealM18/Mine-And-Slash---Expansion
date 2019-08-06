package com.therealm18.mineandslash.expansion.db_lists.initializers;

import com.robertx22.mine_and_slash.api.MineAndSlashAPI;
import com.robertx22.mine_and_slash.db_lists.registry.ISlashRegistryInit;
import com.therealm18.mineandslash.expansion.database.spells.self.haste.SpellSelfHaste;
import com.therealm18.mineandslash.expansion.database.spells.self.speed.SpellSelfSpeed;

public class Spells implements ISlashRegistryInit {

    @Override
    public void registerAll() {

                    MineAndSlashAPI.addSpell(new SpellSelfHaste());
                    MineAndSlashAPI.addSpell(new SpellSelfSpeed());

    }
}