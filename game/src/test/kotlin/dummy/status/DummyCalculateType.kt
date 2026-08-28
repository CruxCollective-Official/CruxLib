package dummy.status

import org.crux.Crux.CRUX_KEY_MANAGER
import org.crux.annotations.InternalCruxApi
import org.crux.status.CalculateType

@InternalCruxApi
enum class DummyCalculateType(
    val type: CalculateType
) {
    ADDITION(CalculateType(CRUX_KEY_MANAGER.create("addition"))),
    MULTIPLICATION(CalculateType(CRUX_KEY_MANAGER.create("multiplication"))),
}
