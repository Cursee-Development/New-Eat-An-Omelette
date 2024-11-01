package com.cursee.eat_an_omelette.core.registry;

import net.minecraft.world.item.Item;

public class ModItemsFabric {

    public static void register() {}

    public static final Item SPANISH_OMELETTE_MIX = RegistryFabric.registerItem("spanish_omelette_mix", () -> new Item(new Item.Properties()));
}
