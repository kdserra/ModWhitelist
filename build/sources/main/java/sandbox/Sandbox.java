package sandbox;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.util.ban.BanTypes;
import sandbox.commands.HelpCommand;
import sandbox.helpers.CommandHelper;
import sandbox.helpers.PlayerHelper;

import java.util.List;

@Plugin(id = "sandbox", name = "Sandbox")
public class Sandbox
{

    @Inject
    private Logger logger;

    public static Object plugin;

    /*
     * @Inject
     * public static Object plugin;
     *
     * @Inject
     * public static Plugin plg;
     */

    @Listener
    public void onServerStart(GameStartedServerEvent event)
    {
        plugin = this;
        Text multiColoredText = Text.builder("[").color(TextColors.BLACK).style(TextStyles.BOLD).append(
                Text.builder("Mod-Whitelist").color(TextColors.GOLD).style(TextStyles.BOLD).build()).append(
                        Text.builder("]").color(TextColors.BLACK).style(TextStyles.BOLD).build()
        ).build();



        CommandHelper.setCommandPrefix(multiColoredText);
        CommandHelper.registerCommand(plugin, new HelpCommand(), "/modwhitelist help" ,Text.of("Lists all Mod-Whitelist commands."), "sandbox.commands.help");


        logger.info("Mod-Whitelist loaded.");
    }


    @Listener
    public void playerJoinedServer(ClientConnectionEvent.Join playerJoinedEvent)
    {
        List<String> whitelistedMods = Lists.newArrayList("minecraft", "mcp", "FML", "forge");

        // Store the clients active mods
        List<String> clientModList = PlayerHelper.getPlayerMods(playerJoinedEvent.getTargetEntity());
        boolean selectedModStatus = false;

        if (!ModWhitelist.isModlistWhitelisted(whitelistedMods, clientModList))
        {
            // Player joined with a modified client.
            String banReason = "Banned for using a modified client.";
            Text banText = Text.of(TextColors.RED, TextStyles.BOLD, banReason);
            PlayerHelper.banPlayer(playerJoinedEvent.getTargetEntity(), BanTypes.PROFILE, banText);
        }
    }
}
