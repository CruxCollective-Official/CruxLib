package org.crux.slot

import org.crux.holder.AmountHolder

interface ImmutableSlot<TYPE> {
    val content: TYPE
}

open class Slot<TYPE>(
    override var content: TYPE
) : ImmutableSlot<TYPE>


interface ImmutableMandateSlot<TYPE : AmountHolder<AMOUNT_TYPE>, AMOUNT_TYPE> : ImmutableSlot<TYPE> {
    override val content: TYPE
    val amount: AMOUNT_TYPE
    val maxAmount: AMOUNT_TYPE
}

/**
 * [AmountHolder] を継承したインスタンスを要素として保持する場合に使用する特殊なスロットです。
 *
 * 内部の要素を直接操作することなく、このスロット自身が `amount`（個数）と `maxAmount`（最大個数）の管理に責任を持ちます。
 *
 * @param TYPE スロットが格納する要素の型（[AmountHolder] を継承している必要があります）
 * @param AMOUNT_TYPE 個数を表現する型
 * @property amount 現在の個数
 * @property maxAmount 許容される最大個数
 */
open class MandateSlot<TYPE : AmountHolder<AMOUNT_TYPE>, AMOUNT_TYPE>(
    content: TYPE
) : Slot<TYPE>(content), ImmutableMandateSlot<TYPE, AMOUNT_TYPE> {

    override var content: TYPE = content
        set(value) {
            field = value
            amount = value.amount
        }
    override var amount: AMOUNT_TYPE = content.amount
        set(value) {
            field = value
            content.amount = value
        }
    override val maxAmount: AMOUNT_TYPE
        get() = content.maxAmount
}