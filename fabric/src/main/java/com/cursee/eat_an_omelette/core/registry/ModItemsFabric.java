package com.cursee.eat_an_omelette.core.registry;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class ModItemsFabric {

    public static void register() {}

    public static final Item SPANISH_OMELETTE_MIX = RegistryFabric.registerItem("spanish_omelette_mix", () -> new Item(new Item.Properties()));

    public static final Item OMELETTE = RegistryFabric.registerItem("omelette", () -> new Item(new Item.Properties().food(
        new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(1.2f)
            .build())));
    public static final Item GOLDEN_OMELETTE = RegistryFabric.registerItem("golden_omelette", () -> new Item(
        new Item.Properties().food(new FoodProperties.Builder()
             .nutrition(8)
             .saturationModifier(2.4f)
             .effect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F)
             .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0F)
            .alwaysEdible().build())));
    public static final Item ENCHANTED_GOLDEN_OMELETTE = RegistryFabric.registerItem("enchanted_golden_omelette", () -> new Item(new Item.Properties().food(
        new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(2.4f)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3), 1.0F)
            .alwaysEdible().build())
        .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));
}
