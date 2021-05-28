package sandbox;

import java.util.List;

public class ModWhitelist
{
    // Returns true if the mod list matches.  Returns false for a mismatch.
    public static boolean isModlistWhitelisted(List<String> modWhitelist, List<String> playerModlist)
    {
        // Create a variable to track the status of each iterations mod validity.
        boolean selectedModStatus = false;

        // Check if the client is using any mods not included in whitelistedMods.
        for (int i = 0; i < playerModlist.size(); i++)
        {
            // Reset selectedModStatus.
            selectedModStatus = false;

            // Check the current client mod against the list of mods allowed.
            for (int j = 0; j < modWhitelist.size(); j++)
            {
                // If client and server are using the same mod, set tracking for that index to be true.
                if (playerModlist.get(i).equals(modWhitelist.get(j)))
                {
                    // Mod is whitelisted, update the tracker variable.
                    selectedModStatus = true;
                    break;
                }
            }

            // If the mod is whitelisted, check the next iterations mod.
            if (!selectedModStatus)
            {
                // This mod is not whitelisted, therefore the supplied mod list is invalid.
                return false;
            }
        }

        // This mod list is whitelisted.
        return true;
    }
}
