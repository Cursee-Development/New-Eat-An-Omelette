package com.cursee.eat_an_omelette.core.registry;

import com.cursee.eat_an_omelette.world.level.block.EnchantedGoldenSpanishPotatoOmeletteBlock;
import com.cursee.eat_an_omelette.world.level.block.GoldenSpanishPotatoOmeletteBlock;
import com.cursee.eat_an_omelette.world.level.block.SpanishPotatoOmeletteBlock;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;

public class ModBlocksFabric {

    public static void register() {}

    public static final Block SPANISH_POTATO_OMELETTE = RegistryFabric.registerBlockWithBlockItem("spanish_potato_omelette", SpanishPotatoOmeletteBlock::new);
    public static final Block GOLDEN_SPANISH_POTATO_OMELETTE = RegistryFabric.registerBlockWithCustomBlockItemProperties("golden_spanish_potato_omelette", GoldenSpanishPotatoOmeletteBlock::new, new Item.Properties().rarity(Rarity.RARE));
    public static final Block ENCHANTED_GOLDEN_SPANISH_POTATO_OMELETTE = RegistryFabric.registerBlockWithCustomBlockItemProperties("enchanted_golden_spanish_potato_omelette", EnchantedGoldenSpanishPotatoOmeletteBlock::new, new Item.Properties().rarity(Rarity.EPIC));
}
