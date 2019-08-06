package com.therealm18.mineandslash.expansion.db_lists.initializers;

import java.util.ArrayList;
import java.util.List;

import com.robertx22.mine_and_slash.database.spells.bases.BaseSpell;
import com.robertx22.mine_and_slash.db_lists.registry.ISlashRegistryInit;
import com.robertx22.mine_and_slash.uncommon.interfaces.IGenerated;
import com.therealm18.mineandslash.expansion.database.spells.self.SpellSelfHaste;

public class Spells  implements ISlashRegistryInit {

    @Override
    public void registerAll() {

        List<BaseSpell> All = new ArrayList<BaseSpell>() {
            {
                {
                    add(new SpellSelfHaste());
                }
            }
        };

        List<BaseSpell> generated = new ArrayList<BaseSpell>() {
            {
                {
//                    add(new SpellBonusEleBasicDmg(Elements.Physical));

                }
            }
        };

        for (BaseSpell spell : generated) {
            IGenerated<BaseSpell> gen = (IGenerated<BaseSpell>) spell;
            gen.generateAllPossibleStatVariations().forEach(x -> All.add(x));
        }

        All.forEach(x -> x.registerToSlashRegistry());

    }
}