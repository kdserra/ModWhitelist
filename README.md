# ModWhitelist

Minecraft Sponge-Forge plugin to restrict mods to a preset list of mods.

# Disclaimer

This mod is in early development, it can still be used if you can figure out how to use it.

ModWhitelist is a fork of [rodel77's](https://github.com/rodel77) Sponge-Forge plugin [ModBanner](https://github.com/rodel77/ModBanner).

# Download

Head to the releases tab, and download the latest version.

# To-do 

* Update the mod using the latest SpongeForge
* Support forcing identical mod versions in config
* Support easy exporting of player's loaded mods
* Add helper command
* Finish command implementations

# Config

modwhitelist.conf
```
ban=true
delay=1000
identical=true
msg="Banned for using a modified client."
whitelist=[]
```

Ban - Automatically auto-ban users who join with a modified client.

Delay - How long to wait before kicking the player, in milliseconds.

Identical - Require identical load order, useful to detect hacked clients who spoof their names.

Msg - The ban message the player will see.

Whitelist - The list of mod names to permit.

# Commands

    mods player <player> 
    mods mod <mod-name>

# License

GNU General Public License v3.0
