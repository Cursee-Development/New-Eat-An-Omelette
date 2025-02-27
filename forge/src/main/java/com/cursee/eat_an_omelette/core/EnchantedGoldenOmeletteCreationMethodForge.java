package com.cursee.eat_an_omelette.core;

import com.cursee.eat_an_omelette.Constants;
import com.cursee.eat_an_omelette.core.registry.ModBlocksForge;
import com.cursee.eat_an_omelette.core.registry.ModItemsForge;
import com.cursee.eat_an_omelette.platform.Services;
import forge.com.cursee.golden_foods.core.registry.ModEnchantmentsForge;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID)
public class EnchantedGoldenOmeletteCreationMethodForge {

    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent anvil) {

        ItemStack slotLeft = anvil.getLeft();
        ItemStack slotRight = anvil.getRight();
        ItemStack slotOutput = anvil.getOutput();

        if (!Services.PLATFORM.isModLoaded("golden_foods")) return;

        if (!EnchantmentHelper.getEnchantments(slotRight).containsKey(ModEnchantmentsForge.GOLDEN_FOODS.get())) return;

        final Integer experienceCost = Math.min(slotLeft.getCount(), 40);

        if (slotLeft.is(ModItemsForge.GOLDEN_OMELETTE.get())) {
            final ItemStack toReturn = new ItemStack(ModItemsForge.ENCHANTED_GOLDEN_OMELETTE.get());
            anvil.setCost(experienceCost);
            anvil.setMaterialCost(slotLeft.getCount());
            anvil.setOutput(toReturn);
        }
        else if (slotLeft.is(ModBlocksForge.GOLDEN_SPANISH_POTATO_OMELETTE.get().asItem())) {
            final ItemStack toReturn = new ItemStack(ModBlocksForge.ENCHANTED_GOLDEN_SPANISH_POTATO_OMELETTE.get().asItem());
            anvil.setCost(experienceCost);
            anvil.setMaterialCost(slotLeft.getCount());
            anvil.setOutput(toReturn);
        }

    }
}
