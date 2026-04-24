package net.semeth.arcanediaries.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.semeth.arcanediaries.block.ModBlocks;
import net.semeth.arcanediaries.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> ACTINIUM_SMELTABLE = List.of(ModItems.ACTINIUM,
                ModBlocks.ACTINIUM_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ACTINIUM_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.ACTINIUM_INGOT.get())
                .unlockedBy("has_actinium", has(ModItems.ACTINIUM_INGOT)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ACTINIUM_INGOT.get(), 9)
                .requires(ModBlocks.ACTINIUM_BLOCK)
                .unlockedBy("has_actinium_block", has(ModBlocks.ACTINIUM_BLOCK)).save(recipeOutput);

        oreSmelting(recipeOutput, ACTINIUM_SMELTABLE, RecipeCategory.MISC, ModItems.ACTINIUM_INGOT.get(), 0.25f, 200, "actinium_ingot");
        oreBlasting(recipeOutput, ACTINIUM_SMELTABLE, RecipeCategory.MISC, ModItems.ACTINIUM_INGOT.get(), 0.25f, 100, "actinium_ingot");

    }
}
