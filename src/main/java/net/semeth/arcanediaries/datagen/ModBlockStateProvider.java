package net.semeth.arcanediaries.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.semeth.arcanediaries.ArcaneDiaries;
import net.semeth.arcanediaries.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper){
        super(output, ArcaneDiaries.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ACTINIUM_BLOCK);

        blockWithItem(ModBlocks.ACTINIUM_ORE);

        blockWithItem(ModBlocks.MAGIC_BLOCK);

        stairsBlock((ModBlocks.ACTINIUM_STAIRS.get()), blockTexture(ModBlocks.ACTINIUM_BLOCK.get()));
        slabBlock(ModBlocks.ACTINIUM_SLAB.get(), blockTexture(ModBlocks.ACTINIUM_BLOCK.get()), blockTexture(ModBlocks.ACTINIUM_BLOCK.get()));

        buttonBlock(ModBlocks.ACTINIUM_BUTTON.get(), blockTexture(ModBlocks.ACTINIUM_BLOCK.get()));
        pressurePlateBlock(ModBlocks.ACTINIUM_PRESSURE_PLATE.get(), blockTexture(ModBlocks.ACTINIUM_BLOCK.get()));

        fenceBlock(ModBlocks.ACTINIUM_FENCE.get(), blockTexture(ModBlocks.ACTINIUM_BLOCK.get()));
        fenceGateBlock(ModBlocks.ACTINIUM_FENCE_GATE.get(), blockTexture(ModBlocks.ACTINIUM_BLOCK.get()));
        wallBlock(ModBlocks.ACTINIUM_WALL.get(), blockTexture(ModBlocks.ACTINIUM_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.ACTINIUM_DOOR.get(), modLoc("block/actinium_door_bottom"), modLoc("block/actinium_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.ACTINIUM_TRAPDOOR.get(), modLoc("block/actinium_trapdoor"), true, "cutout");

        blockItem(ModBlocks.ACTINIUM_STAIRS);
        blockItem(ModBlocks.ACTINIUM_SLAB);
        blockItem(ModBlocks.ACTINIUM_PRESSURE_PLATE);
        blockItem(ModBlocks.ACTINIUM_FENCE_GATE);
        blockItem(ModBlocks.ACTINIUM_TRAPDOOR, "_bottom");

    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("arcanediaries:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("arcanediaries:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
