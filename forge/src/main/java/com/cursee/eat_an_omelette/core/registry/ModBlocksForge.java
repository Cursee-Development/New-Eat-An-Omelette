package com.cursee.eat_an_omelette.core.registry;

import com.cursee.eat_an_omelette.world.level.block.EnchantedGoldenSpanishPotatoOmeletteBlock;
import com.cursee.eat_an_omelette.world.level.block.GoldenSpanishPotatoOmeletteBlock;
import com.cursee.eat_an_omelette.world.level.block.SpanishPotatoOmeletteBlock;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocksForge {

    public static void register() {}

    public static final RegistryObject<Block> SPANISH_POTATO_OMELETTE = RegistryForge.registerBlockWithBlockItem("spanish_potato_omelette", SpanishPotatoOmeletteBlock::new);
    public static final RegistryObject<Block> GOLDEN_SPANISH_POTATO_OMELETTE = RegistryForge.registerBlockWithCustomBlockItemProperties("golden_spanish_potato_omelette", GoldenSpanishPotatoOmeletteBlock::new, new Item.Properties().rarity(Rarity.RARE));
    public static final RegistryObject<Block> ENCHANTED_GOLDEN_SPANISH_POTATO_OMELETTE = RegistryForge.registerBlockWithCustomBlockItemProperties("enchanted_golden_spanish_potato_omelette", EnchantedGoldenSpanishPotatoOmeletteBlock::new, new Item.Properties().rarity(Rarity.EPIC));
}
