package gabzeph.ultrareborn.mixin;

import gabzeph.ultrareborn.entity.GhastFireball;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.mob.GhastEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(GhastEntity.class)
public class GhastExplosionPowerMixin extends FlyingEntity implements Monster, GhastFireball {
    protected GhastExplosionPowerMixin(EntityType<? extends FlyingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow
    private int fireballStrength;

    @Override
    public void setFireballStrength(int fireball) {
        fireballStrength = fireball;
    }
}
