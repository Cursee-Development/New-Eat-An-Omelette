package com.cursee.eat_an_omelette.core;

import com.cursee.eat_an_omelette.core.registry.ModBlocksFabric;
import com.cursee.eat_an_omelette.core.registry.ModItemsFabric;
import com.cursee.eat_an_omelette.platform.Services;
import fabric.com.cursee.golden_foods.GoldenFoods;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import oshi.util.tuples.Triplet;

import java.util.concurrent.atomic.AtomicBoolean;

public class EnchantedGoldenOmeletteCreationMethodFabric {

    public static Triplet<Integer, Integer, ItemStack> createGoldenOmelettes(AnvilMenu instance, ItemStack slotLeft, ItemStack slotRight, ItemStack slotOutput, String leftSlotName, int baseCost, Player player) {

        if (!Services.PLATFORM.isModLoaded("golden_foods")) return null;

        // 1.20.1
        // if (!EnchantmentHelper.getEnchantments(slotRight).containsKey(ModEnchantmentsFabric.GOLDEN_FOODS)) return null;

        // 1.21.1
        final AtomicBoolean foundEnchantment = new AtomicBoolean(false);
        EnchantmentHelper.getEnchantmentsForCrafting(slotRight).keySet().forEach(enchantmentHolder -> {
            if (enchantmentHolder.is(GoldenFoods.GOLDEN_FOODS)) foundEnchantment.set(true);
        });

        if (!foundEnchantment.get()) return null;

        final Integer experienceCost = Math.min(slotLeft.getCount(), 40);

        if (slotLeft.is(ModItemsFabric.GOLDEN_OMELETTE)) {
            final ItemStack toReturn = new ItemStack(ModItemsFabric.ENCHANTED_GOLDEN_OMELETTE);
            return new Triplet<>(experienceCost, slotLeft.getCount(), toReturn);
        }
        else if (slotLeft.is(ModBlocksFabric.GOLDEN_SPANISH_POTATO_OMELETTE.asItem())) {
            final ItemStack toReturn = new ItemStack(ModBlocksFabric.ENCHANTED_GOLDEN_SPANISH_POTATO_OMELETTE.asItem());
            return new Triplet<>(experienceCost, slotLeft.getCount(), toReturn);
        }

        return null;
    }
}
