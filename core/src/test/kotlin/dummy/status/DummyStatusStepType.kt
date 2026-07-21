package dummy.status

import org.crux.game.status.StatusStepType
import org.crux.core.createCruxKey

enum class DummyStatusStepType(
    val type: StatusStepType,
) {
    TEST(StatusStepType(createCruxKey("test"))),
    ;
}