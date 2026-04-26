package net.semeth.arcanediaries.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.semeth.arcanediaries.ArcaneDiaries;
import net.semeth.arcanediaries.block.ModBlocks;
import net.semeth.arcanediaries.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ArcaneDiaries.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.ACTINIUM.get());
        basicItem(ModItems.ACTINIUM_INGOT.get());
        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.RADISH.get());
        basicItem(ModItems.FROSTFIRE_ICE.get());
        basicItem(ModItems.STARLIGHT_ASHES.get());

        buttonItem(ModBlocks.ACTINIUM_BUTTON, ModBlocks.ACTINIUM_BLOCK);
        fenceItem(ModBlocks.ACTINIUM_FENCE, ModBlocks.ACTINIUM_BLOCK);
        wallItem(ModBlocks.ACTINIUM_WALL, ModBlocks.ACTINIUM_BLOCK);

        basicItem(ModBlocks.ACTINIUM_DOOR.asItem());

        handheldItem(ModItems.ACTINIUM_SWORD);
        handheldItem(ModItems.ACTINIUM_PICKAXE);
        handheldItem(ModItems.ACTINIUM_AXE);
        handheldItem(ModItems.ACTINIUM_HOE);
        handheldItem(ModItems.ACTINIUM_SHOVEL);
        handheldItem(ModItems.ACTINIUM_HAMMER);
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock){
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(ArcaneDiaries.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock){
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(ArcaneDiaries.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock){
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", ResourceLocation.fromNamespaceAndPath(ArcaneDiaries.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item){
        return withExistingParent(item.getId().getPath(),
        ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(ArcaneDiaries.MOD_ID, "item/" + item.getId().getPath()));
    }
}
