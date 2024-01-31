package gabzeph.ultrareborn.event;

import gabzeph.ultrareborn.armor.UltraArmor;
import gabzeph.ultrareborn.cardinal.UltradeathWorldComponents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;

public class EntityKilledEvent {

    public static void onEntityKilled(ServerWorld world, Entity entity, LivingEntity killedEntity) {
        if (!(entity instanceof PlayerEntity)) {
            return;
        }
        int week = UltradeathWorldComponents.WEEK.get(world).getValue();
        if (world.random.nextFloat() <= 0.1f) {
            if (killedEntity.getType() == EntityType.HUSK && killedEntity.getName().equals(Text.literal("Ultra Husk"))) {
                killedEntity.dropItem(UltraArmor.ULTRA_HELMET);
            }
            if (killedEntity.getType() == EntityType.WITHER_SKELETON && killedEntity.getName().equals(Text.literal("Ultra Wither Skeleton"))) {
                killedEntity.dropItem(UltraArmor.ULTRA_CHESTPLATE);
            }
            if (killedEntity.getType() == EntityType.ENDERMAN && killedEntity.getName().equals(Text.literal("Ultra Enderman"))) {
                killedEntity.dropItem(UltraArmor.ULTRA_LEGGINGS);
            }
            if (killedEntity.getType() == EntityType.MAGMA_CUBE && killedEntity.getName().equals(Text.literal("Ultra Magma Cube"))) {
                killedEntity.dropItem(UltraArmor.ULTRA_BOOTS);
            }
        }

    }
}
