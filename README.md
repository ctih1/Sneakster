# Sneakster

---

A fun game mode plugin made for spigot (1.21)



## How to install
1. Download the jar from [the releases](https://github.com/ctih1/Sneakster/releases/latest)
2. Place the .jar file in your plugins folder



## Examples



## Commands

 `/invis <player>` - Makes a player invisible. Will default to the command runner if no player is specified
`/settings [setting] [value]` - Changes a setting 

---

## Settings
*Shows the settings and values you can use with the /settings command*


`regen-while-hurt` (yes / no): Whether the invisible player can regenerate health while invisible

`attack-shows-player` (yes / no): If turned on, the player will be visible for about 0.25 seconds after hitting someone

`damage-shows-player` (yes / no): If turned on, the player will be visible for about 0.25 seconds after being hit

## FAQ
Q: Can mobs attack you while invisible? Yes. Mobs will treat the invisible player as if he wasn't invisible.

Q: What permission does a player need to go invisible? To go invisible, a player needs to have the `sneakster.toggle` permission. You can bypass this by giving the player operator status (/op)