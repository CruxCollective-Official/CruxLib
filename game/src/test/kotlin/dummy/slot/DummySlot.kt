package dummy.slot

import org.crux.slot.MandateSlot
import org.crux.slot.MutableSlot

class DummySlot(
    override var content: DummyTank,
    override var amount: Int = content.amount,
    override val maxAmount: Int = content.maxAmount,
) : MutableSlot<DummyTank>, MandateSlot<DummyTank, Int>