package net.semeth.arcanediaries.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.semeth.arcanediaries.ArcaneDiaries;
import net.semeth.arcanediaries.item.custom.ChiselItem;
import net.semeth.arcanediaries.item.custom.FuelItem;
import net.semeth.arcanediaries.item.custom.HammerItem;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ArcaneDiaries.MOD_ID);

    public static final DeferredItem<Item> ACTINIUM = ITEMS.register("actinium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ACTINIUM_INGOT = ITEMS.register("actinium_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));

    public static final DeferredItem<Item> RADISH = ITEMS.register("radish",
            () -> new Item(new Item.Properties().food(ModFoodProperties.RADISH)) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.arcanediaries.radish.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> FROSTFIRE_ICE = ITEMS.register("frostfire_ice",
            () -> new FuelItem(new Item.Properties(), 800));
    public static final DeferredItem<Item> STARLIGHT_ASHES = ITEMS.register("starlight_ashes",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<SwordItem> ACTINIUM_SWORD = ITEMS.register("actinium_sword",
            () -> new SwordItem(ModToolTiers.ACTINIUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.ACTINIUM, 5, 3f))));
    public static final DeferredItem<PickaxeItem> ACTINIUM_PICKAXE = ITEMS.register("actinium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ACTINIUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.ACTINIUM, 1.0F, -2.8f))));
    public static final DeferredItem<ShovelItem> ACTINIUM_SHOVEL = ITEMS.register("actinium_shovel",
            () -> new ShovelItem(ModToolTiers.ACTINIUM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.ACTINIUM, 1.5F, -3.0f))));
    public static final DeferredItem<AxeItem> ACTINIUM_AXE = ITEMS.register("actinium_axe",
            () -> new AxeItem(ModToolTiers.ACTINIUM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.ACTINIUM, 6.0F, -3.2f))));
    public static final DeferredItem<HoeItem> ACTINIUM_HOE = ITEMS.register("actinium_hoe",
            () -> new HoeItem(ModToolTiers.ACTINIUM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.ACTINIUM, 0F, -3.0f))));

    public static final DeferredItem<HammerItem> ACTINIUM_HAMMER = ITEMS.register("actinium_hammer",
            () -> new HammerItem(ModToolTiers.ACTINIUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.ACTINIUM, 7F, -3.5f))));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
