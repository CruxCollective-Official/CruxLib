package dummy.status

import game.status.StatusStepType
import system.key.createCruxKey

enum class DummyStatusStepType(
    val type: StatusStepType,
) {
    TEST(StatusStepType(createCruxKey("test"))),
    ;
}