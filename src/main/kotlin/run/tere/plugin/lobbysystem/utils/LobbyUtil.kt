package run.tere.plugin.lobbysystem.utils

import org.bukkit.Bukkit
import run.tere.plugin.lobbysystem.consts.Lobby
import run.tere.plugin.lobbysystem.events.LobbySystemStartEvent

object LobbyUtil {

    fun startGame(lobby: Lobby) {
        lobby.inGame = true
        val lobbySystemStartEvent = LobbySystemStartEvent(lobby)
        Bukkit.getServer().pluginManager.callEvent(lobbySystemStartEvent)
    }

}