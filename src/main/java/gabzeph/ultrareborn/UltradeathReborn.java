package gabzeph.ultrareborn;

import gabzeph.ultrareborn.armor.UltraArmor;
import gabzeph.ultrareborn.command.AddWeekCommand;
import gabzeph.ultrareborn.command.SetWeekCommand;
import gabzeph.ultrareborn.event.EntityJoinEvent;
import gabzeph.ultrareborn.event.EntityKilledEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.world.ServerWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UltradeathReborn implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "ultradeath-reborn";
    public static final Logger LOGGER = LoggerFactory.getLogger("ultradeath-reborn");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ServerEntityEvents.ENTITY_LOAD.register((Entity entity, ServerWorld world) -> {
			EntityJoinEvent.onEntityJoin(world, entity);
		});
		ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register((ServerWorld world, Entity entity, LivingEntity killedEntity) -> {
			EntityKilledEvent.onEntityKilled(world, entity, killedEntity);
		});
		CommandRegistrationCallback.EVENT.register(SetWeekCommand::register);
		CommandRegistrationCallback.EVENT.register(AddWeekCommand::register);
		UltraArmor.registerModItems();
		LOGGER.info("Hello Fabric world!");
	}
}