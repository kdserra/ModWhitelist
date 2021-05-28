package sandbox.commands;


import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;
import sandbox.Sandbox;

public class Commands
{
    public static void makeCmd(Object plugin)
    {
        CommandSpec commandSpec =
                CommandSpec.builder()
                .description(Text.of("Lists all Mod-Whitelist commands."))
                .permission("sandbox.command.help")
                .executor(new HelpCommand())
                .build();


        Sponge.getCommandManager().register(plugin, commandSpec, "help");
    }
}
