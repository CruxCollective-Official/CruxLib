package dummy.status

import org.crux.Crux.CRUX_KEY_MANAGER
import org.crux.annotations.InternalCruxApi
import org.crux.status.StatusStepType

@InternalCruxApi
enum class DummyStatusStepType(
    val type: StatusStepType,
) {
    TEST(StatusStepType(CRUX_KEY_MANAGER.create("test"))),
    ;
}