package net.semeth.arcanediaries.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.semeth.arcanediaries.ArcaneDiaries;
import net.semeth.arcanediaries.item.ModItems;
import net.semeth.arcanediaries.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {


    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, ArcaneDiaries.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.ACTINIUM.get())
                .add(ModItems.ACTINIUM_INGOT.get());

        tag(ItemTags.SWORDS)
                .add(ModItems.ACTINIUM_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.ACTINIUM_PICKAXE.get());
        tag(ItemTags.AXES)
                .add(ModItems.ACTINIUM_AXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.ACTINIUM_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(ModItems.ACTINIUM_HOE.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ACTINIUM_HELMET.get())
                .add(ModItems.ACTINIUM_CHESTPLATE.get())
                .add(ModItems.ACTINIUM_LEGGINGS.get())
                .add(ModItems.ACTINIUM_BOOTS.get());

        this.tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.ACTINIUM.get());

        this.tag(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.SEMETH_SMITHING_TEMPLATE.get());
    }
}
