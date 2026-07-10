package dummy.status

import game.status.StatusStepType
import system.Key

enum class DummyStatusStepType(
    val type: StatusStepType
) {
    TEST(StatusStepType(Key("crux", "test")))
}
