package run.tere.plugin.lobbysystem.schedulers

import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.scheduler.BukkitRunnable
import run.tere.plugin.lobbysystem.LobbySystem
import run.tere.plugin.lobbysystem.utils.LobbyUtil
import run.tere.plugin.lobbysystem.utils.PlayerUtil

class LobbyMainRunnable: BukkitRunnable() {

    var count: Int = 30

    override fun run() {
        val lobby = LobbySystem.instance.lobby
        for (player in Bukkit.getOnlinePlayers()) {
            if (!lobby.players.contains(player.uniqueId)) {
                lobby.players.add(player.uniqueId)
            }
        }
        if (!lobby.inGame) {
            val playerSize = lobby.players.size
            if (playerSize >= lobby.maxPlayerSize) {
                LobbyUtil.startGame(lobby)
                cancel()
                return
            } else if (playerSize >= lobby.minPlayerSize) {
                Bukkit.broadcastMessage("§e残り $count 秒でゲームを開始します")
                PlayerUtil.playSound(Sound.UI_BUTTON_CLICK, 1F, 1F)
                if (count <= 0) {
                    LobbyUtil.startGame(lobby)
                    cancel()
                    return
                }
                count--
            } else {
                count = 30
            }
        }
    }

}