package net.semeth.arcanediaries.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.semeth.arcanediaries.ArcaneDiaries;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ArcaneDiaries.MOD_ID);

    public static final DeferredItem<Item> ACTINIUM = ITEMS.register("actinium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ACTINIUM_INGOT = ITEMS.register("actinium_ingot",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
