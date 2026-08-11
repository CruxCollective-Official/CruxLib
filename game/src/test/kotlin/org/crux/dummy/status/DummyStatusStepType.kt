package org.crux.dummy.status

import org.crux.Crux.Companion.CRUX_KEY_MANAGER
import org.crux.status.StatusStepType

enum class DummyStatusStepType(
    val type: StatusStepType,
) {
    TEST(StatusStepType(CRUX_KEY_MANAGER.create("test"))),
    ;
}