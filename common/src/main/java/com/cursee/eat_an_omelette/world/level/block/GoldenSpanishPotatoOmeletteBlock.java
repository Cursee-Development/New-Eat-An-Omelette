package com.cursee.eat_an_omelette.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class GoldenSpanishPotatoOmeletteBlock extends CakeBlock {

    public GoldenSpanishPotatoOmeletteBlock() {
        super(Properties.ofFullCopy(Blocks.CAKE));
    }

    protected ItemInteractionResult useItemOn(ItemStack $$0, BlockState $$1, Level $$2, BlockPos $$3, Player $$4, InteractionHand $$5, BlockHitResult $$6) {
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    protected InteractionResult useWithoutItem(BlockState $$0, Level $$1, BlockPos $$2, Player $$3, BlockHitResult $$4) {
        if ($$1.isClientSide) {
            if (eat($$1, $$2, $$0, $$3).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if ($$3.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }

        return eat($$1, $$2, $$0, $$3);
    }

    protected static InteractionResult eat(LevelAccessor $$0, BlockPos $$1, BlockState $$2, Player $$3) {
        if (!$$3.canEat(false)) {
            return InteractionResult.PASS;
        } else {
            $$3.awardStat(Stats.EAT_CAKE_SLICE);
            $$3.getFoodData().eat(4, 1.2F);
            $$3.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1));
            $$3.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 1));
            int $$4 = (Integer)$$2.getValue(BITES);
            $$0.gameEvent($$3, GameEvent.EAT, $$1);
            if ($$4 < 6) {
                $$0.setBlock($$1, (BlockState)$$2.setValue(BITES, $$4 + 1), 3);
            } else {
                $$0.removeBlock($$1, false);
                $$0.gameEvent($$3, GameEvent.BLOCK_DESTROY, $$1);
            }

            return InteractionResult.SUCCESS;
        }
    }
}
