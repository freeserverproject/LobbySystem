package run.tere.plugin.lobbysystem.utils

import org.bukkit.Bukkit
import org.bukkit.Sound

object PlayerUtil {

    fun playSound(sound: Sound, volume: Float, pitch: Float) {
        for (player in Bukkit.getOnlinePlayers()) {
            player.playSound(player.location, sound, volume, pitch)
        }
    }

}