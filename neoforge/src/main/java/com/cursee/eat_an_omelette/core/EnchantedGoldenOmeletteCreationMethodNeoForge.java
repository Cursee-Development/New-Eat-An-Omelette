package com.cursee.eat_an_omelette.core;

import com.cursee.eat_an_omelette.Constants;
import com.cursee.eat_an_omelette.core.registry.ModBlocksNeoForge;
import com.cursee.eat_an_omelette.core.registry.ModItemsNeoForge;
import com.cursee.eat_an_omelette.platform.Services;
import common.com.cursee.golden_foods.GoldenFoods;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AnvilUpdateEvent;

import java.util.concurrent.atomic.AtomicBoolean;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class EnchantedGoldenOmeletteCreationMethodNeoForge {

    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent anvil) {

        ItemStack slotLeft = anvil.getLeft();
        ItemStack slotRight = anvil.getRight();
        ItemStack slotOutput = anvil.getOutput();

        if (!Services.PLATFORM.isModLoaded("golden_foods")) return;

        // 1.20.1
        // if (!EnchantmentHelper.getEnchantments(slotRight).containsKey(ModEnchantmentsForge.GOLDEN_FOODS.get())) return;

        // 1.21.1
        final AtomicBoolean foundEnchantment = new AtomicBoolean(false);
        EnchantmentHelper.getEnchantmentsForCrafting(slotRight).keySet().forEach(enchantmentHolder -> {
            if (enchantmentHolder.is(GoldenFoods.GOLDEN_FOODS)) foundEnchantment.set(true);
        });

        if (!foundEnchantment.get()) return;

        final Integer experienceCost = Math.min(slotLeft.getCount(), 40);

        if (slotLeft.is(ModItemsNeoForge.GOLDEN_OMELETTE.get())) {
            final ItemStack toReturn = new ItemStack(ModItemsNeoForge.ENCHANTED_GOLDEN_OMELETTE.get());
            anvil.setCost(experienceCost);
            anvil.setMaterialCost(slotLeft.getCount());
            anvil.setOutput(toReturn);
        }
        else if (slotLeft.is(ModBlocksNeoForge.GOLDEN_SPANISH_POTATO_OMELETTE.get().asItem())) {
            final ItemStack toReturn = new ItemStack(ModBlocksNeoForge.ENCHANTED_GOLDEN_SPANISH_POTATO_OMELETTE.get().asItem());
            anvil.setCost(experienceCost);
            anvil.setMaterialCost(slotLeft.getCount());
            anvil.setOutput(toReturn);
        }

    }
}
