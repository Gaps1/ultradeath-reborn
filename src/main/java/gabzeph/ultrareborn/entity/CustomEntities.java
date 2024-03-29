package gabzeph.ultrareborn.entity;

import gabzeph.ultrareborn.armor.UltraArmor;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.GhastEntity;
import net.minecraft.entity.mob.MagmaCubeEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.text.Text;

public class CustomEntities {

    public static LivingEntity createUltraHusk(LivingEntity entity) {
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
        entity.setCustomNameVisible(false);
        setAllEquipmentDropChancesZero((MobEntity) entity);
        return entity;
    }


    public static LivingEntity createUltraMagmaCube(MagmaCubeEntity entity) {
        entity.setSize(15, true);
        entity.setCustomName(Text.literal("Ultra Magma Cube"));
        entity.setCustomNameVisible(false);
        return (LivingEntity) entity;
    }

    public static LivingEntity createUltraEnderman(LivingEntity entity) {
        entity.setHealth(80.0f);
        EntityAttributeInstance attack_damage = entity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        EntityAttributeInstance speed = entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
        attack_damage.setBaseValue(20.0d);
        speed.setBaseValue(0.45d);
        entity.setCustomName(Text.literal("Ultra Enderman"));
        entity.setCustomNameVisible(false);
        return entity;
    }

    public static LivingEntity createUltraWitherSkeleton(LivingEntity entity) {
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
        entity.setCustomNameVisible(false);
        setAllEquipmentDropChancesZero((MobEntity) entity);
        return entity;
    }

    public static LivingEntity createImperialSkeleton(LivingEntity entity) {
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

    public static LivingEntity setGenericIron(LivingEntity entity, boolean... equip) {
        // 0 = helmet; 1 = chest; 2 = leggings; 3 = boots; 4 = sword
        if (equip[0]) {entity.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.IRON_HELMET));}
        if (equip[1]) {entity.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));}
        if (equip[2]) {entity.equipStack(EquipmentSlot.LEGS, new ItemStack(Items.IRON_LEGGINGS));}
        if (equip[3]) {entity.equipStack(EquipmentSlot.FEET, new ItemStack(Items.IRON_BOOTS));}
        if (equip[4]) {entity.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));}
        return entity;
    }

    public static LivingEntity setGenericDiamond(LivingEntity entity, boolean... equip) {
        // 0 = helmet; 1 = chest; 2 = leggings; 3 = boots; 4 = sword
        if (equip[0]) {entity.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.DIAMOND_HELMET));}
        if (equip[1]) {entity.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));}
        if (equip[2]) {entity.equipStack(EquipmentSlot.LEGS, new ItemStack(Items.DIAMOND_LEGGINGS));}
        if (equip[3]) {entity.equipStack(EquipmentSlot.FEET, new ItemStack(Items.DIAMOND_BOOTS));}
        if (equip[4]) {entity.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));}
        return entity;
    }

    public static LivingEntity setEnchants(LivingEntity entity, Enchantment enchantment, int level, boolean... equip) {
        // 0 = helmet; 1 = chest; 2 = leggings; 3 = boots; 4 = sword
        if (equip[0]) {entity.getEquippedStack(EquipmentSlot.HEAD).addEnchantment(enchantment, level);}
        if (equip[1]) {entity.getEquippedStack(EquipmentSlot.CHEST).addEnchantment(enchantment, level);}
        if (equip[2]) {entity.getEquippedStack(EquipmentSlot.LEGS).addEnchantment(enchantment, level);}
        if (equip[3]) {entity.getEquippedStack(EquipmentSlot.FEET).addEnchantment(enchantment, level);}
        if (equip[4]) {entity.getEquippedStack(EquipmentSlot.MAINHAND).addEnchantment(enchantment, level);}


        return entity;
    }

    public static GhastEntity createPolterghost(GhastEntity entity) {
        ((GhastFireball)entity).setFireballStrength(5);
        return entity;
    }

    public static SkeletonEntity createJusticiero(SkeletonEntity entity) {
        ItemStack bow = new ItemStack(Items.BOW);
        bow.addEnchantment(Enchantments.PUNCH, 5);
        bow.addEnchantment(Enchantments.POWER, 10);
        ItemStack chainmail_chestplate = new ItemStack(Items.CHAINMAIL_CHESTPLATE);
        chainmail_chestplate.addEnchantment(Enchantments.PROJECTILE_PROTECTION,12);
        ItemStack chainmail_leggings = new ItemStack(Items.CHAINMAIL_LEGGINGS);
        chainmail_leggings.addEnchantment(Enchantments.PROJECTILE_PROTECTION,12);
        ItemStack chainmail_boots = new ItemStack(Items.CHAINMAIL_BOOTS);
        chainmail_boots.addEnchantment(Enchantments.PROJECTILE_PROTECTION,12);
        ItemStack mining_fatigue_arrow = new ItemStack(Items.TIPPED_ARROW);
        PotionUtil.setPotion(mining_fatigue_arrow, Potions.STRONG_SLOWNESS);
        mining_fatigue_arrow.setCount(64);
        EntityAttributeInstance knockback_resistance = entity.getAttributeInstance(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE);
        EntityAttributeInstance armor = entity.getAttributeInstance(EntityAttributes.GENERIC_ARMOR);
        EntityAttributeInstance armor_toughness = entity.getAttributeInstance(EntityAttributes.GENERIC_ARMOR_TOUGHNESS);
        knockback_resistance.setBaseValue(10.0d);
        armor.setBaseValue(4.0d);
        armor_toughness.setBaseValue(8.0d);
        entity.equipStack(EquipmentSlot.CHEST, chainmail_chestplate);
        entity.equipStack(EquipmentSlot.LEGS, chainmail_leggings);
        entity.equipStack(EquipmentSlot.FEET, chainmail_boots);
        entity.equipStack(EquipmentSlot.OFFHAND, mining_fatigue_arrow);
        entity.equipStack(EquipmentSlot.MAINHAND, bow);
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, -1, 1));
        setAllEquipmentDropChancesZero(entity);
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
