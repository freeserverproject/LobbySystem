package run.tere.plugin.lobbysystem.consts

import java.util.*

class Lobby(val name: String, val minPlayerSize: Int, val maxPlayerSize: Int) {

    val uuid: UUID = UUID.randomUUID()
    val players: MutableList<UUID> = ArrayList()
    var inGame: Boolean = false
    var canJoinInMidway: Boolean = false

}