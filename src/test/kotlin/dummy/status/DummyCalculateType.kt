package dummy.status

import game.status.CalculateType
import system.key.createCruxKey

enum class DummyCalculateType(
    val type: CalculateType
) {
    ADD(CalculateType(createCruxKey("add")))
}
