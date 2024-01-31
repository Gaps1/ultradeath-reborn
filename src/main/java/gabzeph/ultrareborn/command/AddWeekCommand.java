package gabzeph.ultrareborn.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import gabzeph.ultrareborn.UltradeathReborn;
import gabzeph.ultrareborn.cardinal.UltradeathComponents;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;

public class AddWeekCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(CommandManager.literal("week")
                .then(CommandManager.literal("add").executes(AddWeekCommand::run)));
    }

    private static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerWorld world = context.getSource().getWorld();
        UltradeathComponents.WEEK.get(world).addWeek();
        context.getSource().sendFeedback(() -> Text.literal("Week increased by 1."), true);
        return 0;
    }
}
