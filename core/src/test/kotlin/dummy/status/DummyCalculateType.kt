package dummy.status

import org.crux.game.status.CalculateType
import org.crux.core.createCruxKey

enum class DummyCalculateType(
    val type: CalculateType
) {
    ADDITION(CalculateType(createCruxKey("addition"))),
    MULTIPLICATION(CalculateType(createCruxKey("multiplication"))),
}
