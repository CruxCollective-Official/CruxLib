package org.crux.stack

interface Stack<STACK_TYPE : Stack<STACK_TYPE, AMOUNT_TYPE>, AMOUNT_TYPE : Number> : AmountImpl<AMOUNT_TYPE> {
    var amount: AMOUNT_TYPE

    fun equalsOriginalData(other: STACK_TYPE): Boolean
    fun copy(): STACK_TYPE
}