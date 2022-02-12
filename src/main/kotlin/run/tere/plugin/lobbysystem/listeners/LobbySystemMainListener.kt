package run.tere.plugin.lobbysystem.listeners

import org.bukkit.Sound
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import run.tere.plugin.lobbysystem.LobbySystem
import run.tere.plugin.lobbysystem.utils.LobbyUtil

class LobbySystemMainListener: Listener {

    @EventHandler
    fun onPlayerJoin(e: PlayerJoinEvent) {
        val player = e.player
        val lobby = LobbySystem.instance.lobby
        if (lobby.inGame && !lobby.canJoinInMidway) {
            player.kickPlayer("§cゲーム中の為ゲームに参加できません!")
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_DIDGERIDOO, 1F, 0.5F)
            return
        }
        val prevPlayerSize = lobby.players.size
        if (prevPlayerSize >= lobby.maxPlayerSize) {
            player.kickPlayer("§cこの部屋は人がいっぱいです!")
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_DIDGERIDOO, 1F, 0.5F)
            return
        }
    }

    @EventHandler
    fun onPlayerQuit(e: PlayerQuitEvent) {
        val player = e.player
        val lobby = LobbySystem.instance.lobby
        lobby.players.remove(player.uniqueId)
    }

}
