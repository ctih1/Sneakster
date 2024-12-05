# Sneakster

---

A fun game mode plugin made for spigot (1.21)



## How to install
1. Download the jar from [the releases](https://github.com/ctih1/Sneakster/releases/latest)
2. Place the .jar file in your plugins folder

## How it works
1. You make a player invisible with the `/invis <player>` command
2. The player is invisible when shifting. NOTE: The mid stage between running and shifting (aka shift running) does NOT make the player invisible. To fix this, simply let go of W

## Examples

### General showcase:
![generalshowcase](https://github.com/user-attachments/assets/b2163bd7-0f4c-43f7-9153-1dbde307c99a)


### Attacking setting turned on
![settingsshowcase](https://github.com/user-attachments/assets/d55d6dff-ccc8-4676-8595-9512e26e17d1)


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
