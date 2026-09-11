package dummy.status

import org.crux.annotations.InternalCruxApi
import org.crux.status.StatusStep

@InternalCruxApi
enum class DummyStatusStep(
    val statusStep: StatusStep,
) {
    TEST(StatusStep())
}