package gabzeph.ultrareborn.cardinal;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.world.WorldComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.world.WorldComponentInitializer;
import net.minecraft.util.Identifier;

public final class UltradeathWorldComponents implements WorldComponentInitializer {
    public static final ComponentKey<IntComponent> WEEK =
            ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier("ultradeath-reborn:week"),
                    IntComponent.class);
    @Override
    public void registerWorldComponentFactories(WorldComponentFactoryRegistry registry) {
        registry.register(WEEK, world -> new WeekComponent());
    }
}
