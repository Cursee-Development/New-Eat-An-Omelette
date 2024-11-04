package com.cursee.eat_an_omelette.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class EnchantedGoldenSpanishPotatoOmeletteBlock extends CakeBlock {

    public EnchantedGoldenSpanishPotatoOmeletteBlock() {
        super(Properties.copy(Blocks.CAKE));
    }

    // copied from CakeBlock, removed candle interaction
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {

        ItemStack itemStack = player.getItemInHand(hand);

        if (level.isClientSide) {

            if (eat(level, pos, state, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if (itemStack.isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }

        return eat(level, pos, state, player);
    }

    // copied from CakeBlock, adjusted eat value and added effects
    protected static InteractionResult eat(LevelAccessor level, BlockPos pos, BlockState state, Player player) {
        player.awardStat(Stats.EAT_CAKE_SLICE);

        player.getFoodData().eat(8, 2.4F);
        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 400, 1));
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0));
        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0));
        player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3));

        int i = (Integer)state.getValue(BITES);
        level.gameEvent(player, GameEvent.EAT, pos);
        if (i < 6) {
            level.setBlock(pos, (BlockState)state.setValue(BITES, i + 1), 3);
        } else {
            level.removeBlock(pos, false);
            level.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
        }

        return InteractionResult.SUCCESS;
    }
}
