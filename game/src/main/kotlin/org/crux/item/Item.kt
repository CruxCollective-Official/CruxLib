package org.crux.item

interface Item<AMOUNT_TYPE : Number> {
    fun maxAmount(): AMOUNT_TYPE
}