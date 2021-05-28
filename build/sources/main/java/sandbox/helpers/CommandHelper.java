package sandbox.helpers;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;
import sandbox.commands.HelpCommand;

import java.util.List;

public class CommandHelper
{
    public static Text commandPrefix;

    public static void setCommandPrefix(Text newCommandPrefix)
    {
        CommandHelper.commandPrefix = newCommandPrefix;
    }

    public static void registerCommand(Object plugin, CommandExecutor cmdExecutor, String command, Text description, String permission)
    {
        CommandSpec commandSpec =
                        CommandSpec.builder()
                        .description(description)
                        .permission(permission)
                        .executor(cmdExecutor)
                        .build();


        Sponge.getCommandManager().register(plugin, commandSpec, "modwhitelist.help");
    }
}
