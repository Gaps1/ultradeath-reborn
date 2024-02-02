package gabzeph.ultrareborn.event;

import gabzeph.ultrareborn.cardinal.UltradeathWorldComponents;
import gabzeph.ultrareborn.entity.CreeperCharged;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.dimension.DimensionTypes;

import static gabzeph.ultrareborn.entity.CustomEntities.*;

public class EntityJoinEvent {
    public static void onEntityJoin(ServerWorld world, Entity entity) {
        if (!(entity instanceof LivingEntity)) {
            return;
        }
        LivingEntity Lentity = (LivingEntity) entity;
        int week = UltradeathWorldComponents.WEEK.get(world).getValue();
        float random = world.random.nextFloat();

        switch (week) {
            case 2:
                if (entity instanceof ZombieEntity) {
                    if (random <= 0.1f) {
                        setGenericIron(Lentity, false, true, true, true, false);
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1));
                    }
                    break;
                }
                if (entity instanceof SkeletonEntity && !(entity instanceof WitherSkeletonEntity)) {
                    if (random <= 0.1f) {
                        setGenericIron(Lentity, false, true, true, true, false);
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1));
                    }
                    break;
                }
                if (entity instanceof EndermanEntity) {
                    if (random <= 0.1f) {
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1, 1));
                    }
                    break;
                }
                if (entity instanceof SpiderEntity) {
                    if (random <= 0.1f) {
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1, 1));
                    }
                    break;
                }
                break;
            case 3:
                if (entity instanceof ZombieEntity) {
                    if (random <= 0.3f) {
                        setGenericIron(Lentity, false, true, true, true, false);
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1));
                    }
                    break;
                }
                if (entity instanceof SkeletonEntity && !(entity instanceof WitherSkeletonEntity)) {
                    if (random <= 0.3f) {
                        setGenericIron(Lentity, false, true, true, true, false);
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1));
                    } else if (random <= 0.4f) {
                        createImperialSkeleton(Lentity);
                    }
                    break;
                }
                if (entity instanceof EndermanEntity) {
                    if (random <= 0.3f) {
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1, 1));
                    }
                    break;
                }
                if (entity instanceof SpiderEntity) {
                    if (random <= 0.3f) {
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1, 1));
                    }
                    break;
                }
                if (entity instanceof GhastEntity) {
                    if (random <= 0.5f) {
                        createPolterghost((GhastEntity) Lentity);
                    }
                    break;
                }
                break;
            case 4:
                if (entity instanceof HuskEntity) {
                    if (random <= 0.03f) {
                        createUltraHusk(Lentity);
                    }
                    break;
                }
                if (entity instanceof ZombieEntity) {
                    if (random <= 0.8f) {
                        setGenericIron(Lentity, false, true, true, true, false);
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1));
                    } else if (random <= 0.9f) {
                        setGenericDiamond(Lentity, true, true, true, true, true);
                        Lentity.setHealth(40.0f);
                    }
                    break;
                }
                if (entity instanceof WitherSkeletonEntity) {
                    if (random <= 0.03f) {
                        createUltraWitherSkeleton(Lentity);
                    } else if (random <= 0.13f) {
                        setGenericIron(Lentity, true, true, true, true, false);
                    }
                    break;
                }
                if (entity instanceof SkeletonEntity) {
                    if (random <= 0.8f) {
                        setGenericIron(Lentity, false, true, true, true, false);
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1));
                    } else if (random <= 0.95f) {
                        createImperialSkeleton(Lentity);
                    }
                    break;
                }
                if (entity instanceof EndermanEntity) {
                    if (world.getDimensionKey() == DimensionTypes.THE_END) {
                        if (random <= 0.6f) {
                            Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, -1, 1));
                            Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, -1));
                            Lentity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue(25.0d);
                        }
                        break;
                    }
                    if (random <= 0.8f) {
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1, 1));
                    } else if (random <= 0.83f) {
                        createUltraEnderman(Lentity);
                    }
                    break;
                }
                if (entity instanceof SpiderEntity) {
                    if (random <= 0.8f) {
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1, 1));
                    }
                    break;
                }
                if (entity instanceof GhastEntity) {
                    if (random <= 0.6f) {
                        createPolterghost((GhastEntity) Lentity);
                    }
                    break;
                }
                if (entity instanceof MagmaCubeEntity) {
                    if (random <= 0.03f) {
                        createUltraMagmaCube((MagmaCubeEntity) Lentity);
                    }
                    break;
                }
                if (entity instanceof ZombifiedPiglinEntity) {
                    if (random <= 0.5f) {
                        setGenericIron(Lentity, true, true, true, true, false);
                    }
                    break;
                }
                if (entity instanceof CreeperEntity) {
                    CreeperEntity Centity = ((CreeperEntity) Lentity);
                    if (world.getDimensionKey() == DimensionTypes.THE_NETHER) {
                        if (random <= 0.3f) {
                            ((CreeperCharged)Centity).setCharged(Centity);
                        }
                    } else if (world.getDimensionKey() == DimensionTypes.THE_END) {
                        if (random <= 0.2f) {
                            ((CreeperCharged)Centity).setCharged(Centity);
                        }
                    } else {
                        if (random <= 0.4f) {
                            ((CreeperCharged)Centity).setCharged(Centity);
                        }
                    }
                    break;
                }
                if (entity instanceof WitchEntity) {
                    if (random <= 0.05f) {
                        Lentity.setHealth(32.0f);
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, -1, 1));
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, -1, 1));
                    }
                    break;
                }
            case 5:
                if (entity instanceof HuskEntity) {
                    if (random <= 0.03f) {
                        createUltraHusk(Lentity);
                    }
                    break;
                }
                if (entity instanceof ZombieEntity) {
                    if (random <= 0.5f) {
                        setGenericIron(Lentity, false, true, true, true, false);
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1));
                    } else {
                        setGenericDiamond(Lentity, true, true, true, true, true);
                        Lentity.setHealth(40.0f);
                    }
                    break;
                }
                if (entity instanceof WitherSkeletonEntity) {
                    if (random <= 0.03f) {
                        createUltraWitherSkeleton(Lentity);
                    } else if (random <= 0.13f) {
                        setGenericIron(Lentity, true, true, true, true, false);
                    }
                    break;
                }
                if (entity instanceof SkeletonEntity) {
                    if (random <= 0.25f) {
                        setGenericIron(Lentity, false, true, true, true, false);
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1));
                    } else if (random <= 0.45f) {
                        WitherSkeletonEntity witherSkeleton = new WitherSkeletonEntity(EntityType.WITHER_SKELETON, world);
                        witherSkeleton.initialize(world, world.getLocalDifficulty(Lentity.getBlockPos()), SpawnReason.NATURAL, null, null);
                        setGenericIron(witherSkeleton, true, true, true, true, false);
                        Lentity.discard();
                        world.spawnEntity(witherSkeleton);
                    } else if (random <= 0.5f) {
                        createJusticiero((SkeletonEntity) Lentity);
                    } else {
                        createImperialSkeleton(Lentity);
                    }
                    break;
                }
                if (entity instanceof EndermanEntity) {
                    if (world.getDimensionKey() == DimensionTypes.THE_END) {
                        if (random <= 0.6f) {
                            Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, -1, 1));
                            Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, -1));
                            Lentity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue(25.0d);
                        }
                        break;
                    }
                    if (random <= 0.8f) {
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1, 1));
                    } else if (random <= 0.83f) {
                        createUltraEnderman(Lentity);
                    }
                    break;
                }
                if (entity instanceof SpiderEntity) {
                    if (random <= 0.8f) {
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1, 1));
                    }
                    if (random <= 0.3f) {
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, -1));
                    }
                    break;
                }
                if (entity instanceof GhastEntity) {
                    if (random <= 0.6f) {
                        createPolterghost((GhastEntity) Lentity);
                    }
                    break;
                }
                if (entity instanceof MagmaCubeEntity) {
                    if (random <= 0.03f) {
                        createUltraMagmaCube((MagmaCubeEntity) Lentity);
                    }
                    break;
                }
                if (entity instanceof ZombifiedPiglinEntity) {
                    if (random <= 0.75f) {
                        setGenericIron(Lentity, true, true, true, true, false);
                    }
                    break;
                }
                if (entity instanceof CreeperEntity) {
                    CreeperEntity Centity = ((CreeperEntity) Lentity);
                    if (world.getDimensionKey() == DimensionTypes.THE_NETHER) {
                        if (random <= 0.3f) {
                            ((CreeperCharged)Centity).setCharged(Centity);
                        }
                    } else if (world.getDimensionKey() == DimensionTypes.THE_END) {
                        if (random <= 0.2f) {
                            ((CreeperCharged)Centity).setCharged(Centity);
                        }
                    } else {
                        if (random <= 0.4f) {
                            ((CreeperCharged)Centity).setCharged(Centity);
                        }
                    }
                    break;
                }
                if (entity instanceof WitchEntity) {
                    if (random <= 0.15f) {
                        Lentity.setHealth(32.0f);
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, -1, 1));
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, -1, 1));
                    }
                    break;
                }
            case 6:
                if (entity instanceof ZombieEntity) {
                    if (random <= 0.5f) {
                        setGenericIron(Lentity, false, true, true, true, false);
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1));
                    } else {
                        setGenericDiamond(Lentity, true, true, true, true, true);
                        Lentity.setHealth(60.0f);
                    }
                    break;
                }
                if (entity instanceof WitherSkeletonEntity) {
                    if (random <= 0.5f) {
                        setGenericIron(Lentity, true, true, true, true, false);
                    }
                    break;
                }
                if (entity instanceof SkeletonEntity) {
                    if (random <= 0.25f) {
                        setGenericIron(Lentity, false, true, true, true, false);
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1));
                    } else if (random <= 0.45f) {
                        WitherSkeletonEntity witherSkeleton = new WitherSkeletonEntity(EntityType.WITHER_SKELETON, world);
                        witherSkeleton.initialize(world, world.getLocalDifficulty(Lentity.getBlockPos()), SpawnReason.NATURAL, null, null);
                        setGenericIron(witherSkeleton, true, true, true, true, false);
                        Lentity.discard();
                        world.spawnEntity(witherSkeleton);
                    } else if (random <= 0.5f) {
                        createJusticiero((SkeletonEntity) Lentity);
                    } else {
                        createImperialSkeleton(Lentity);
                    }
                    break;
                }
                if (entity instanceof EndermanEntity) {
                    if (world.getDimensionKey() == DimensionTypes.THE_END) {
                        if (random <= 0.6f) {
                            Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, -1, 1));
                            Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, -1));
                            Lentity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue(25.0d);
                        }
                        break;
                    }
                    Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, -1, 1));
                    Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, -1));
                    Lentity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue(25);
                    break;
                }
                if (entity instanceof SpiderEntity) {
                    if (world.random.nextFloat() <= 0.6f) {
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1, 1));
                    }
                    if (world.random.nextFloat() <= 0.6f) {
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, -1));
                    }
                    if (world.random.nextFloat() <= 0.6f) {
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, -1, 1));
                    }
                    if (world.random.nextFloat() <= 0.6f) {
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, -1, 1));
                    }
                    if (world.random.nextFloat() <= 0.6f) {
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, -1, 1));
                    }
                    break;
                }
                if (entity instanceof GhastEntity) {
                    if (random <= 0.6f) {
                        createPolterghost((GhastEntity) Lentity);
                    }
                    break;
                }
                if (entity instanceof MagmaCubeEntity) {
                    if (random <= 0.03f) {
                        createUltraMagmaCube((MagmaCubeEntity) Lentity);
                    }
                    break;
                }
                if (entity instanceof ZombifiedPiglinEntity) {
                    if (random <= 0.95f) {
                        setGenericIron(Lentity, true, true, true, true, false);
                        setEnchants(Lentity, Enchantments.PROTECTION, 3, true, true, true, true, false);
                    }
                    break;
                }
                if (entity instanceof CreeperEntity) {
                    CreeperEntity Centity = ((CreeperEntity) Lentity);
                    if (world.getDimensionKey() == DimensionTypes.THE_NETHER) {
                        ((CreeperCharged)Centity).setCharged(Centity);
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, -1));
                    } else if (world.getDimensionKey() == DimensionTypes.THE_END) {
                        ((CreeperCharged)Centity).setCharged(Centity);
                        Lentity.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.TOTEM_OF_UNDYING));
                    } else {
                        ((CreeperCharged)Centity).setCharged(Centity);
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, -1));
                    }
                    break;
                }
                if (entity instanceof WitchEntity) {
                    if (random <= 0.3f) {
                        Lentity.setHealth(32.0f);
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, -1, 1));
                        Lentity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, -1, 1));
                    }
                    break;
                }
        }
    }
}
