package dummy.status

import org.crux.game.status.CalculateType
import org.crux.system.key.createCruxKey

enum class DummyCalculateType(
    val type: CalculateType
) {
    ADD(CalculateType(createCruxKey("add")))
}
