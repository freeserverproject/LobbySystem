package run.tere.plugin.lobbysystem

import org.bukkit.plugin.java.JavaPlugin
import run.tere.plugin.lobbysystem.consts.Lobby
import run.tere.plugin.lobbysystem.listeners.LobbySystemMainListener
import run.tere.plugin.lobbysystem.schedulers.LobbyMainRunnable

class LobbySystem: JavaPlugin() {

    companion object {

        lateinit var instance: LobbySystem

        fun registerLobby(lobby: Lobby) {
            instance.lobby = lobby
            val lobbyMainRunnable = LobbyMainRunnable()
            lobbyMainRunnable.runTaskTimer(instance, 0L, 20L)
        }

    }

    lateinit var lobby: Lobby

    override fun onEnable() {
        instance = this
        server.pluginManager.registerEvents(LobbySystemMainListener(), this)
    }

}