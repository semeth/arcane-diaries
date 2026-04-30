package net.semeth.arcanediaries.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.semeth.arcanediaries.ArcaneDiaries;
import net.semeth.arcanediaries.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ArcaneDiaries.MOD_ID);

    public static final Supplier<CreativeModeTab> ARCANE_DIARIES_TAB = CREATIVE_MODE_TAB.register("arcane_diaries_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.ACTINIUM.get()))
                    .title(Component.translatable("creativetab.arcanediaries.arcane_diaries"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.ACTINIUM_SWORD);
                        output.accept(ModItems.ACTINIUM_AXE);
                        output.accept(ModItems.ACTINIUM_SHOVEL);
                        output.accept(ModItems.ACTINIUM_HOE);
                        output.accept(ModItems.ACTINIUM_PICKAXE);

                        output.accept(ModItems.ACTINIUM_HAMMER);

                        output.accept(ModItems.ACTINIUM_HELMET);
                        output.accept(ModItems.ACTINIUM_CHESTPLATE);
                        output.accept(ModItems.ACTINIUM_LEGGINGS);
                        output.accept(ModItems.ACTINIUM_BOOTS);

                        output.accept(ModItems.ACTINIUM_HORSE_ARMOR);

                        output.accept(ModItems.ACTINIUM);
                        output.accept(ModItems.ACTINIUM_INGOT);
                        output.accept(ModBlocks.ACTINIUM_ORE);
                        output.accept(ModBlocks.ACTINIUM_BLOCK);
                        output.accept(ModBlocks.MAGIC_BLOCK);

                        output.accept(ModItems.RADISH);
                        output.accept(ModItems.FROSTFIRE_ICE);
                        output.accept(ModItems.STARLIGHT_ASHES);
                        output.accept(ModItems.CHISEL);

                        output.accept(ModBlocks.ACTINIUM_STAIRS);
                        output.accept(ModBlocks.ACTINIUM_SLAB);

                        output.accept(ModBlocks.ACTINIUM_PRESSURE_PLATE);
                        output.accept(ModBlocks.ACTINIUM_BUTTON);

                        output.accept(ModBlocks.ACTINIUM_FENCE);
                        output.accept(ModBlocks.ACTINIUM_FENCE_GATE);
                        output.accept(ModBlocks.ACTINIUM_WALL);

                        output.accept(ModBlocks.ACTINIUM_DOOR);
                        output.accept(ModBlocks.ACTINIUM_TRAPDOOR);

                        output.accept(ModBlocks.ACTINIUM_LAMP);
                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
