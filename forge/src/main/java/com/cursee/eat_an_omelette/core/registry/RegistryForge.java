package com.cursee.eat_an_omelette.core.registry;

import com.cursee.eat_an_omelette.Constants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class RegistryForge {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Constants.MOD_ID);

    public static void register(IEventBus modEventBus) {

        ModBlocksForge.register();
        ModItemsForge.register();
        ModTabsForge.register();

        RegistryForge.BLOCKS.register(modEventBus);
        RegistryForge.ITEMS.register(modEventBus);
        RegistryForge.TABS.register(modEventBus);
    }

    public static <T extends Block> RegistryObject<T> registerBlock(String id, Supplier<T> supplier) {
        return RegistryForge.BLOCKS.register(id, supplier);
    }

    public static <T extends Item> RegistryObject<T> registerItem(String id, Supplier<T> supplier) {
        return RegistryForge.ITEMS.register(id, supplier);
    }

    public static <T extends Block> RegistryObject<T> registerBlockWithBlockItem(String id, Supplier<T> supplier) {
        RegistryObject<T> registeredBlock = RegistryForge.registerBlock(id, supplier);
        RegistryForge.registerItem(id, () -> new BlockItem(registeredBlock.get(), new Item.Properties()));
        return registeredBlock;
    }

    public static <T extends Block> RegistryObject<T> registerBlockWithCustomBlockItemProperties(String id, Supplier<T> supplier, Item.Properties blockItemProperties) {
        RegistryObject<T> registeredBlock = RegistryForge.registerBlock(id, supplier);
        RegistryForge.registerItem(id, () -> new BlockItem(registeredBlock.get(), blockItemProperties));
        return registeredBlock;
    }

    public static <T extends CreativeModeTab> RegistryObject<T> registerTab(String id, Supplier<T> supplier) {
        return RegistryForge.TABS.register(id, supplier);
    }
}
