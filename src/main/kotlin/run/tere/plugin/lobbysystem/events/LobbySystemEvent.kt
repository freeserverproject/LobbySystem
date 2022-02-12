package run.tere.plugin.lobbysystem.events

import org.bukkit.event.Event
import org.bukkit.event.HandlerList
import run.tere.plugin.lobbysystem.consts.Lobby

open class LobbySystemEvent(val lobby: Lobby): Event() {

    private val handlers = HandlerList()

    override fun getHandlers(): HandlerList {
        return handlers
    }

    fun getHandlerList(): HandlerList {
        return handlers
    }

}