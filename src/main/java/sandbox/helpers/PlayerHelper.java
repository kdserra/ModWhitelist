package sandbox.helpers;

import com.google.common.collect.Lists;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.handshake.NetworkDispatcher;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.service.ban.BanService;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.ban.Ban;
import org.spongepowered.api.util.ban.BanType;

import java.util.List;
import java.util.Map;

public class PlayerHelper
{
    public static void banPlayer(Player player, BanType banType, Text banReason)
    {
        BanService banService = Sponge.getServiceManager().provide(BanService.class).get();
        Ban ban = Ban.builder().type(banType).profile(player.getProfile()).reason(banReason).build();
        banService.addBan(ban);
        player.kick(banReason);
    }

    private static List<String> getModDataList(Map<String, String> mapDataList)
    {
        List<String> modNameList = Lists.newArrayList();
        for (Map.Entry<String, String> mod : mapDataList.entrySet())
        {
            modNameList.add(mod.getKey());
        }
        return modNameList;
    }

    public static List<String> getPlayerMods(Player player)
    {
        NetworkDispatcher networkDispatcher = ((EntityPlayerMP) player).connection.netManager.channel().attr(NetworkDispatcher.FML_DISPATCHER).get();
        Map<String,String> rawModListData = networkDispatcher.getModList();
        List<String> playerModList = getModDataList(rawModListData);
        return playerModList;
    }
}
