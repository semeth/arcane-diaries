package net.semeth.arcanediaries.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.semeth.arcanediaries.util.ModTags;

public class ModToolTiers {
    public static final Tier ACTINIUM = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_ACTINIUM_TOOL,
            1400, 4f, 3f, 28, () -> Ingredient.of(ModItems.ACTINIUM));
}
