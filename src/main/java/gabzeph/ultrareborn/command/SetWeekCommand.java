package gabzeph.ultrareborn.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import dev.onyxstudios.cca.api.v3.world.WorldComponentFactoryRegistry;
import gabzeph.ultrareborn.UltradeathReborn;
import gabzeph.ultrareborn.cardinal.IntComponent;
import gabzeph.ultrareborn.cardinal.UltradeathComponents;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.PlainTextContent;
import net.minecraft.text.Text;

import java.util.function.Supplier;

public class SetWeekCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(CommandManager.literal("week")
                .then(CommandManager.literal("set")
                        .then(CommandManager.argument("value", IntegerArgumentType.integer())
                                .executes(SetWeekCommand::run))));
    }

    private static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerWorld world = context.getSource().getWorld();
        int value = IntegerArgumentType.getInteger(context, "value");
        UltradeathComponents.WEEK.get(world).setWeek(value);
        context.getSource().sendFeedback(() -> Text.literal("Week -> " + Integer.toString(value)), true);
        return 0;
    }
}
