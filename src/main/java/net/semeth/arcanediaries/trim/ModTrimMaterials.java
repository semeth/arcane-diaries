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
import net.semeth.arcanediaries.ArcaneDiaries;
import net.semeth.arcanediaries.item.ModItems;

import java.util.Map;

public class ModTrimMaterials {

    public static final ResourceKey<TrimMaterial> ACTINIUM =
            ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(ArcaneDiaries.MOD_ID, "actinium"));

    public static void bootstrap(BootstrapContext<TrimMaterial> context){
        register(context, ACTINIUM, ModItems.ACTINIUM.get(), Style.EMPTY.withColor(TextColor.parseColor("#031cfc").getOrThrow()), 0.5F);
    }

    private static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> trimKey, Item item,
                                 Style style, float itemModelIndex){
        TrimMaterial trimmaterial = TrimMaterial.create(trimKey.location().getPath(), item, itemModelIndex,
                Component.translatable(Util.makeDescriptionId("trim_material", trimKey.location())).withStyle(style), Map.of());
        context.register(trimKey, trimmaterial);
    }

}
