package org.crux.slot

import org.crux.holder.AmountHolder

interface Slot<TYPE> {
    val content: TYPE
}

interface MutableSlot<TYPE> : Slot<TYPE> {
    override var content: TYPE
}

interface MandateSlot<TYPE : AmountHolder<AMOUNT_TYPE>, AMOUNT_TYPE : Number> : Slot<TYPE> {
    var amount: AMOUNT_TYPE
    val maxAmount: AMOUNT_TYPE
}