package dummy

import org.crux.holder.AmountHolder

class DummyTank (
    override var amount: Int,
    override val maxAmount: Int = 100
) : AmountHolder<Int>
