package net.semeth.arcanediaries.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.semeth.arcanediaries.ArcaneDiaries;
import net.semeth.arcanediaries.block.ModBlocks;
import net.semeth.arcanediaries.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ArcaneDiaries.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ACTINIUM_BLOCK.get())
                .add(ModBlocks.ACTINIUM_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.ACTINIUM_SLAB.get())
                .add(ModBlocks.ACTINIUM_STAIRS.get())
                .add(ModBlocks.ACTINIUM_PRESSURE_PLATE.get())
                .add(ModBlocks.ACTINIUM_BUTTON.get())
                .add(ModBlocks.ACTINIUM_FENCE.get())
                .add(ModBlocks.ACTINIUM_FENCE_GATE.get())
                .add(ModBlocks.ACTINIUM_WALL.get())
                .add(ModBlocks.ACTINIUM_DOOR.get())
                .add(ModBlocks.ACTINIUM_TRAPDOOR.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ACTINIUM_ORE.get());

        tag(BlockTags.FENCES).add(ModBlocks.ACTINIUM_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.ACTINIUM_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.ACTINIUM_WALL.get());

        tag(ModTags.Blocks.NEEDS_ACTINIUM_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_ACTINIUM_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_ACTINIUM_TOOL);

    }
}
