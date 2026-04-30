package net.semeth.arcanediaries.trim;

import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.neoforged.neoforge.registries.DeferredItem;
import net.semeth.arcanediaries.ArcaneDiaries;
import net.semeth.arcanediaries.item.ModItems;

import java.util.Map;

public class ModTrimPatterns {
    public static final ResourceKey<TrimPattern> SEMETH = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(ArcaneDiaries.MOD_ID, "semeth"));

    public static void bootstrap(BootstrapContext<TrimPattern> context){
        register(context, ModItems.SEMETH_SMITHING_TEMPLATE, SEMETH);
    }

    private static void register(BootstrapContext<TrimPattern> context, DeferredItem<Item> item, ResourceKey<TrimPattern> key){
        TrimPattern trimPattern = new TrimPattern(key.location(), item.getDelegate(),
                Component.translatable(Util.makeDescriptionId("trim_pattern", key.location())), false);
        context.register(key, trimPattern);
    }
}
