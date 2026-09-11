package dummy.status

import org.crux.annotations.InternalCruxApi
import org.crux.modify.CalculateModifier

@InternalCruxApi
enum class DummyCalculateType(
    val calculateModifier: CalculateModifier<Int>
) {
    ADDITIONAL(
        object : CalculateModifier<Int>(1) {
            override fun calc(target: Int, value: Int): Int {
                return target + value
            }
        }
    )
}