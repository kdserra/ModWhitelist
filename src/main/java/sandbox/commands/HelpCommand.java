package sandbox.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyle;
import org.spongepowered.api.text.format.TextStyles;
import sandbox.helpers.CommandHelper;

import java.util.List;

public class HelpCommand implements CommandExecutor
{

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException
    {
        Text prefix = Text.of( Text.of(TextColors.BLACK, TextStyles.BOLD, "["),
                      Text.of(TextColors.GOLD, TextStyles.BOLD, "Mod-Whitelist"),
                      Text.of(TextColors.BLACK, TextStyles.BOLD, "] ") );


        String[] cmdList = {
                        "/modwhitelist help\n",
                        "/modwhitelist remove <mod-id>\n",
                        "/modwhitelist autoadd\n",
                        "/modwhitelist punishment <type>\n",
                        "/modwhitelist setkickmsg\n",
                        "/modwhitelist setbanmsg\n",
                        "/modwhitelist reload\n"
                        };


        TextColor txtColor = TextColors.GOLD;

        // Initialize outputMsg
        Text outputMsg = Text.of("");

        // Loop for the amount of commands
        for (int i = 0; i < cmdList.length ; i++)
        {
            // Append the prefix with the iterations command.
            outputMsg = outputMsg.toBuilder().append( prefix ).append( Text.of(txtColor, cmdList[i]) ).build();
        }


        src.sendMessage(outputMsg);
        return CommandResult.success();
    }
}