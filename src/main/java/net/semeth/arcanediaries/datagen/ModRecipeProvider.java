package net.semeth.arcanediaries.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.semeth.arcanediaries.ArcaneDiaries;
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

        stairBuilder(ModBlocks.ACTINIUM_STAIRS.get(), Ingredient.of(ModItems.ACTINIUM_INGOT)).group("actinium_ingot")
                .unlockedBy("has_actinium_ingot", has(ModItems.ACTINIUM_INGOT)).save(recipeOutput);


        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ACTINIUM_SLAB.get(), ModItems.ACTINIUM_INGOT.get());

        buttonBuilder(ModBlocks.ACTINIUM_BUTTON.get(), Ingredient.of(ModItems.ACTINIUM_INGOT.get())).group("actinium_ingot")
                .unlockedBy("has_actinium_ingot", has(ModItems.ACTINIUM_INGOT.get())).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.ACTINIUM_PRESSURE_PLATE.get(), ModItems.ACTINIUM_INGOT.get());
        fenceBuilder(ModBlocks.ACTINIUM_FENCE.get(), Ingredient.of(ModItems.ACTINIUM_INGOT.get())).group("actinium_ingot")
                .unlockedBy("has_actinium_ingot", has(ModItems.ACTINIUM_INGOT.get())).save(recipeOutput);
        fenceGateBuilder(ModBlocks.ACTINIUM_FENCE_GATE.get(), Ingredient.of(ModItems.ACTINIUM_INGOT.get())).group("actinium_ingot")
                .unlockedBy("has_actinium_ingot", has(ModItems.ACTINIUM_INGOT.get())).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ACTINIUM_WALL.get(), ModItems.ACTINIUM_INGOT.get());
        doorBuilder(ModBlocks.ACTINIUM_DOOR.get(), Ingredient.of(ModItems.ACTINIUM_INGOT.get())).group("actinium_ingot")
                .unlockedBy("has_actinium_ingot", has(ModItems.ACTINIUM_INGOT.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocks.ACTINIUM_TRAPDOOR.get(), Ingredient.of(ModItems.ACTINIUM_INGOT.get())).group("actinium_ingot")
                .unlockedBy("has_actinium_ingot", has(ModItems.ACTINIUM_INGOT.get())).save(recipeOutput);

        trimSmithing(recipeOutput, ModItems.SEMETH_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(ArcaneDiaries.MOD_ID, "semeth"));

    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup){
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup){
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }
}
