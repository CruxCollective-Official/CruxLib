package org.crux.dummy.status

import org.crux.Crux.Companion.CRUX_KEY_MANAGER
import org.crux.status.CalculateType

enum class DummyCalculateType(
    val type: CalculateType
) {
    ADDITION(CalculateType(CRUX_KEY_MANAGER.create("addition"))),
    MULTIPLICATION(CalculateType(CRUX_KEY_MANAGER.create("multiplication"))),
}
