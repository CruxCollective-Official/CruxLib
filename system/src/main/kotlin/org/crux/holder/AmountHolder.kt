package org.crux.holder

interface AmountHolder<AMOUNT_TYPE : Number> {
    var amount: AMOUNT_TYPE
    val maxAmount: AMOUNT_TYPE
}