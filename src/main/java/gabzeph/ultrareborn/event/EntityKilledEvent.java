package gabzeph.ultrareborn.event;

import gabzeph.ultrareborn.armor.UltraArmor;
import gabzeph.ultrareborn.cardinal.UltradeathComponents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;

public class EntityKilledEvent {

    public static void onEntityKilled(ServerWorld world, Entity entity, LivingEntity killedEntity) {
        if (!(entity instanceof PlayerEntity)) {
            return;
        }
        int week = UltradeathComponents.WEEK.get(world).getValue();
        if (world.random.nextFloat() >= 0.03f) {
            if (killedEntity.getName() == Text.literal("Ultra Husk")) {
                ItemStack item = new ItemStack(UltraArmor.ULTRA_HELMET);
                ItemEntity drop = new ItemEntity(world, killedEntity.getX(), killedEntity.getY(), killedEntity.getZ(), item);
                drop.setVelocity(drop.getVelocity().add((world.random.nextFloat() - world.random.nextFloat()) * 0.1f, world.random.nextFloat() * 0.05f, (world.random.nextFloat() - world.random.nextFloat()) * 0.1f));
                world.spawnEntity(drop);
            }
            if (killedEntity.getName() == Text.literal("Ultra Wither Skeleton")) {
                ItemStack item = new ItemStack(UltraArmor.ULTRA_CHESTPLATE);
                ItemEntity drop = new ItemEntity(world, killedEntity.getX(), killedEntity.getY(), killedEntity.getZ(), item);
                drop.setVelocity(drop.getVelocity().add((world.random.nextFloat() - world.random.nextFloat()) * 0.1f, world.random.nextFloat() * 0.05f, (world.random.nextFloat() - world.random.nextFloat()) * 0.1f));
                world.spawnEntity(drop);
            }
            if (killedEntity.getName() == Text.literal("Ultra Enderman")) {
                ItemStack item = new ItemStack(UltraArmor.ULTRA_LEGGINGS);
                ItemEntity drop = new ItemEntity(world, killedEntity.getX(), killedEntity.getY(), killedEntity.getZ(), item);
                drop.setVelocity(drop.getVelocity().add((world.random.nextFloat() - world.random.nextFloat()) * 0.1f, world.random.nextFloat() * 0.05f, (world.random.nextFloat() - world.random.nextFloat()) * 0.1f));
                world.spawnEntity(drop);
            }
            if (killedEntity.getName() == Text.literal("Ultra Magma Cube")) {
                ItemStack item = new ItemStack(UltraArmor.ULTRA_BOOTS);
                ItemEntity drop = new ItemEntity(world, killedEntity.getX(), killedEntity.getY(), killedEntity.getZ(), item);
                drop.setVelocity(drop.getVelocity().add((world.random.nextFloat() - world.random.nextFloat()) * 0.1f, world.random.nextFloat() * 0.05f, (world.random.nextFloat() - world.random.nextFloat()) * 0.1f));
                world.spawnEntity(drop);
            }
        }

    }
}
