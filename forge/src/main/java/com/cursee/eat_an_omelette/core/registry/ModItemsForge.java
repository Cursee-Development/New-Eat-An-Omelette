package com.cursee.eat_an_omelette.core.registry;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class ModItemsForge {

    public static void register() {}

    public static final RegistryObject<Item> SPANISH_OMELETTE_MIX = RegistryForge.registerItem("spanish_omelette_mix", () -> new Item(new Item.Properties()));
}
