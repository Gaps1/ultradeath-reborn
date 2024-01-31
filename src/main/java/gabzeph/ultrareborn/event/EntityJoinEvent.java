package gabzeph.ultrareborn.event;

import gabzeph.ultrareborn.cardinal.UltradeathWorldComponents;
import gabzeph.ultrareborn.entity.CreeperCharged;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.dimension.DimensionTypes;

import static gabzeph.ultrareborn.entity.CustomEntities.*;

public class EntityJoinEvent {
    public static void onEntityJoin(ServerWorld world, Entity entity) {
        if (!(entity instanceof LivingEntity)) {
            return;
        }
        LivingEntity Lentity = (LivingEntity) entity;
        int week = UltradeathWorldComponents.WEEK.get(world).getValue();
        //BoolComponent boolComp = UltradeathEntityComponents.CUSTOM_DROPS.get(Lentity);

        if (week == 2) {
            if (world.random.nextFloat() <= 0.1f) { // 10% chance
                if (entity instanceof ZombieEntity || entity instanceof SkeletonEntity) {
                    getGenericIron(Lentity);
                    Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1));
                    return;
                }
                if (entity instanceof EndermanEntity || entity instanceof SpiderEntity) {
                    Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1, 1));
                    return;
                }
            }
        }
        if (week == 3) {
            if (world.random.nextFloat() <= 0.3f) { // 30% chance
                if (entity instanceof ZombieEntity || entity instanceof SkeletonEntity) {
                    getGenericIron(Lentity);
                    Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1));
                    return;
                }
                if (entity instanceof EndermanEntity || entity instanceof SpiderEntity) {
                    Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1, 1));
                    return;
                }

            }
            if (world.random.nextFloat() <= 0.1f) { // 10% chance
                if (entity instanceof SkeletonEntity) {
                    getImperialSkeleton(Lentity);
                    return;
                }
            }
            if (world.random.nextFloat() <= 0.05f) { // 5% chance
                if (entity instanceof SkeletonEntity) {
                    Entity vehicle = entity.getControllingVehicle();
                    if (vehicle != null) {
                        getImperialSkeleton(Lentity);
                        return;
                    }
                }
            }
            if (world.random.nextFloat() <= 0.5f) { // 50% chance
                if (entity instanceof GhastEntity) {
                    getPolterghost((GhastEntity) Lentity);
                    return;
                }
            }
        }

        if (week == 4) {
            if (world.random.nextFloat() <= 0.8f) { // 80% chance
                if (entity instanceof ZombieEntity && !(entity instanceof HuskEntity) || entity instanceof SkeletonEntity) {
                    getGenericIron(Lentity);
                    Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1));
                    return;
                }
                if (entity instanceof EndermanEntity || entity instanceof SpiderEntity) {
                    Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1, 1));
                    return;
                }

            }
            if (world.random.nextFloat() <= 0.6f) { // 60% chance
                if (entity instanceof GhastEntity) {
                    getPolterghost((GhastEntity) Lentity);
                    return;
                }
                if (entity.getWorld().getDimensionKey().equals(DimensionTypes.THE_END)) {
                    if (entity instanceof EndermanEntity) {
                        EntityAttributeInstance attack_damage = (Lentity).getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
                        attack_damage.setBaseValue(25.0f);
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, -1, 1));
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, -1));
                        return;
                    }
                }
            }
            if (world.random.nextFloat() <= 0.15f) { // 15% chance
                if (entity instanceof SkeletonEntity) {
                    getImperialSkeleton(Lentity);
                    return;
                }
            }
            if (world.random.nextFloat() <= 0.1f) { // 10% chance
                if (entity instanceof SkeletonEntity) {
                    Entity vehicle = entity.getControllingVehicle();
                    if (vehicle != null) {
                        getImperialSkeleton(Lentity);
                        return;
                    }
                }

                if (entity instanceof WitherSkeletonEntity) {
                    getGenericIron(Lentity);
                    Lentity.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.IRON_HELMET));
                    return;
                }

                if (entity instanceof ZombieEntity && !(entity instanceof HuskEntity)) {
                    Lentity.setHealth(40.0f);
                    Lentity.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.DIAMOND_HELMET));
                    Lentity.equipStack(EquipmentSlot.LEGS, new ItemStack(Items.DIAMOND_LEGGINGS));
                    Lentity.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
                    Lentity.equipStack(EquipmentSlot.FEET, new ItemStack(Items.DIAMOND_BOOTS));
                    Lentity.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
                    return;
                }
            }
            if (entity instanceof CreeperEntity) {
                CreeperEntity Centity = (CreeperEntity) Lentity;
                if (world.getDimensionKey().equals(DimensionTypes.OVERWORLD)) {
                    if (world.random.nextFloat() <= 0.4f) {
                        ((CreeperCharged) entity).setCharged(Centity);
                        return;
                    }
                }
                if (world.getDimensionKey().equals(DimensionTypes.THE_NETHER)) {
                    if (world.random.nextFloat() <= 0.3f) {
                        ((CreeperCharged) entity).setCharged(Centity);
                        return;
                    }
                }
                if (world.getDimensionKey().equals(DimensionTypes.THE_END)) {
                    if (world.random.nextFloat() <= 0.2f) {
                        ((CreeperCharged) entity).setCharged(Centity);
                        return;
                    }
                }
            }
            if (world.random.nextFloat() <= 0.5f) {
                if (entity instanceof ZombifiedPiglinEntity) {
                    getGenericIron(Lentity);
                    Lentity.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.IRON_HELMET));
                    return;
                }
            }
            if (world.random.nextFloat() <= 0.01f) {
                if (entity instanceof WitchEntity) {
                    Lentity.setHealth(32.0f);
                    Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, -1, 1));
                    Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, -1, 1));
                    return;
                }
            }

            if (world.random.nextFloat() <= 0.03f) { // 3% chance
                if (entity instanceof HuskEntity) {
                    getUltraHusk(Lentity);
                    return;
                }
                if (entity instanceof WitherSkeletonEntity) {
                    getUltraWitherSkeleton(Lentity);
                    return;
                }
                if (entity instanceof EndermanEntity) {
                    getUltraEnderman(Lentity);
                    return;
                }
                if (entity instanceof MagmaCubeEntity) {
                    if (Lentity.getName().equals(Text.literal("Ultra Magma Cube"))) {
                        return;
                    }
                    getUltraMagmaCube((MagmaCubeEntity) Lentity);
                    return;
                }
            }
        }
    }
}
