package com.cursee.eat_an_omelette.core.registry;

import com.cursee.eat_an_omelette.Constants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class RegistryFabric {

    public static void register() {

        ModBlocksFabric.register();
        ModItemsFabric.register();
        ModTabsFabric.register();
    }

    public static <T extends Block> T registerBlock(String id, Supplier<T> supplier) {
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, id), supplier.get());
    }

    public static <T extends Item> T registerItem(String id, Supplier<T> supplier) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, id), supplier.get());
    }

    public static <T extends Block> T registerBlockWithBlockItem(String id, Supplier<T> supplier) {
        T registeredBlock = registerBlock(id, supplier);
        RegistryFabric.registerItem(id, () -> new BlockItem(registeredBlock, new Item.Properties()));
        return registeredBlock;
    }

    public static <T extends Block> T registerBlockWithCustomBlockItemProperties(String id, Supplier<T> supplier, Item.Properties blockItemProperties) {
        T registeredBlock = RegistryFabric.registerBlock(id, supplier);
        RegistryFabric.registerItem(id, () -> new BlockItem(registeredBlock, blockItemProperties));
        return registeredBlock;
    }

    public static <T extends CreativeModeTab> T registerTab(String id, Supplier<T> supplier) {
        return Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, id), supplier.get());
    }
}
