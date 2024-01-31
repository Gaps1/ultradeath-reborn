package gabzeph.ultrareborn.event;

import gabzeph.ultrareborn.armor.UltraArmor;
import gabzeph.ultrareborn.cardinal.UltradeathComponents;
import gabzeph.ultrareborn.entity.CreeperCharged;
import gabzeph.ultrareborn.entity.GhastFireball;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.dimension.DimensionTypes;

public class EntityJoinEvent {
    public static void onEntityJoin(ServerWorld world, Entity entity) {
        int week = UltradeathComponents.WEEK.get(world).getValue();
        if (!(entity instanceof LivingEntity)) {
            return;
        }
        LivingEntity Lentity = (LivingEntity) entity;

        if (week == 2) {
            if (world.random.nextFloat() <= 0.1f) { // 10% chance
                if(entity instanceof ZombieEntity || entity instanceof SkeletonEntity) {
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
                if(entity instanceof ZombieEntity || entity instanceof SkeletonEntity) {
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
                if(entity instanceof ZombieEntity || entity instanceof SkeletonEntity) {
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
                if (entity.getWorld().getDimension().equals(DimensionTypes.THE_END)) {
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

                if (entity instanceof ZombieEntity) {
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
                        ((CreeperCharged)entity).setCharged(Centity);
                        return;
                    }
                }
                if (world.getDimensionKey().equals(DimensionTypes.THE_NETHER)) {
                    if (world.random.nextFloat() <= 0.3f) {
                        ((CreeperCharged)entity).setCharged(Centity);
                        return;
                    }
                }
                if (world.getDimensionKey().equals(DimensionTypes.THE_END)) {
                    if (world.random.nextFloat() <= 0.2f) {
                        ((CreeperCharged)entity).setCharged(Centity);
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
                    if (entity.getCustomName() == Text.literal("Ultra Magma Cube")) {
                        return;
                    }
                    getUltraMagmaCube((MagmaCubeEntity) Lentity);
                    return;
                }
            }
        }
    }

    public static LivingEntity getUltraHusk(LivingEntity entity) {
        entity.setHealth(120.0f);
        ItemStack ultraHelmet = new ItemStack(UltraArmor.ULTRA_HELMET);
        ultraHelmet.addEnchantment(Enchantments.PROTECTION, 7);
        ItemStack ultraChestplate = new ItemStack(UltraArmor.ULTRA_CHESTPLATE);
        ultraHelmet.addEnchantment(Enchantments.PROTECTION, 7);
        ItemStack ultraLeggings = new ItemStack(UltraArmor.ULTRA_LEGGINGS);
        ultraHelmet.addEnchantment(Enchantments.PROTECTION, 7);
        ItemStack ultraBoots = new ItemStack(UltraArmor.ULTRA_BOOTS);
        ultraHelmet.addEnchantment(Enchantments.PROTECTION, 7);
        ItemStack diamondSword = new ItemStack(Items.DIAMOND_SWORD);
        diamondSword.addEnchantment(Enchantments.FIRE_ASPECT, 10);
        diamondSword.addEnchantment(Enchantments.SHARPNESS, 10);
        diamondSword.addEnchantment(Enchantments.KNOCKBACK, 7);
        entity.equipStack(EquipmentSlot.HEAD, ultraHelmet);
        entity.equipStack(EquipmentSlot.CHEST, ultraChestplate);
        entity.equipStack(EquipmentSlot.LEGS, ultraLeggings);
        entity.equipStack(EquipmentSlot.FEET, ultraBoots);
        entity.equipStack(EquipmentSlot.MAINHAND, diamondSword);
        entity.setCustomName(Text.literal("Ultra Husk"));
        setAllEquipmentDropChancesZero((MobEntity) entity);
        return entity;
    }


    public static LivingEntity getUltraMagmaCube(MagmaCubeEntity entity) {
        entity.setSize(15, true);
        entity.setCustomName(Text.literal("Ultra Magma Cube"));
        return (LivingEntity) entity;
    }

    public static LivingEntity getUltraEnderman(LivingEntity entity) {
        entity.setHealth(80.0f);
        EntityAttributeInstance attack_damage = entity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        EntityAttributeInstance speed = entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
        attack_damage.setBaseValue(20.0d);
        speed.setBaseValue(0.45d);
        entity.setCustomName(Text.literal("Ultra Enderman"));
        return entity;
    }

    public static LivingEntity getUltraWitherSkeleton(LivingEntity entity) {
        entity.setHealth(120.0f);
        EntityAttributeInstance attack_damage = entity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        EntityAttributeInstance speed = entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
        attack_damage.setBaseValue(16.0d);
        speed.setBaseValue(0.4d);
        entity.equipStack(EquipmentSlot.FEET, new ItemStack(Items.DIAMOND_BOOTS));
        entity.equipStack(EquipmentSlot.LEGS, new ItemStack(Items.DIAMOND_LEGGINGS));
        entity.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
        entity.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.DIAMOND_HELMET));
        entity.setCustomName(Text.literal("Ultra Wither Skeleton"));
        setAllEquipmentDropChancesZero((MobEntity) entity);
        return entity;
    }

    public static LivingEntity getImperialSkeleton(LivingEntity entity) {
        ItemStack imperialBow = new ItemStack(Items.BOW);
        imperialBow.addEnchantment(Enchantments.POWER, 5);
        imperialBow.addEnchantment(Enchantments.PUNCH, 3);
        entity.equipStack(EquipmentSlot.FEET, new ItemStack(Items.DIAMOND_BOOTS));
        entity.equipStack(EquipmentSlot.LEGS, new ItemStack(Items.DIAMOND_LEGGINGS));
        entity.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
        entity.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.DIAMOND_HELMET));
        entity.equipStack(EquipmentSlot.MAINHAND, imperialBow);
        setAllEquipmentDropChancesZero((MobEntity) entity);
        return entity;
    }

    public static LivingEntity getGenericIron(LivingEntity entity) {
        entity.equipStack(EquipmentSlot.FEET, new ItemStack(Items.IRON_BOOTS));
        entity.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
        entity.equipStack(EquipmentSlot.LEGS, new ItemStack(Items.IRON_LEGGINGS));
        return entity;
    }

    public static GhastEntity getPolterghost(GhastEntity entity) {
        ((GhastFireball)entity).setFireballStrength(5);
        return entity;
    }

    public static void setAllEquipmentDropChancesZero(MobEntity entity) {
        entity.setEquipmentDropChance(EquipmentSlot.HEAD, 0.0f);
        entity.setEquipmentDropChance(EquipmentSlot.FEET, 0.0f);
        entity.setEquipmentDropChance(EquipmentSlot.CHEST, 0.0f);
        entity.setEquipmentDropChance(EquipmentSlot.LEGS, 0.0f);
        entity.setEquipmentDropChance(EquipmentSlot.OFFHAND, 0.0f);
        entity.setEquipmentDropChance(EquipmentSlot.MAINHAND, 0.0f);
    }
}
