package gabzeph.ultrareborn.mixin;

import gabzeph.ultrareborn.entity.CreeperCharged;
import net.minecraft.client.render.entity.feature.SkinOverlayOwner;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CreeperEntity.class)
public abstract class CreeperChargedMixin extends HostileEntity implements SkinOverlayOwner, CreeperCharged {

    @Mutable
    @Shadow
    private static final TrackedData<Boolean> CHARGED = DataTracker.registerData(CreeperEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    @Shadow public abstract boolean shouldRenderOverlay();

    protected CreeperChargedMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void setCharged(CreeperEntity entity) {
        this.dataTracker.set(CHARGED, true);
        this.shouldRenderOverlay();
    }
}
