package dummy.status

import game.status.CalculateType
import system.Key

enum class DummyCalculateType(
    val type: CalculateType
) {
    ADD(CalculateType(Key("crux", "add")))
}
