package org.crux.slot

import org.crux.holder.AmountHolder

/**
 * CruxLib内において [Slot] として扱われるにはこちらを継承する必要があります。
 *
 * @param TYPE スロットが格納する要素の型
 * @property content 格納されているデータ
 */
interface Slot<TYPE> {
    val content: TYPE
}

/**
 * 保持する要素を外部から変更可能（ミュータブル）にした [Slot] です。
 *
 * @param TYPE スロットが格納する要素の型
 * @property content 格納されている変更可能なデータ
 */
interface MutableSlot<TYPE> : Slot<TYPE> {
    override var content: TYPE
}

/**
 * [AmountHolder] を継承したインスタンスを要素として保持する場合に使用する特殊なスロットです。
 *
 * 内部の要素を直接操作することなく、このスロット自身が `amount`（個数）と `maxAmount`（最大個数）の管理に責任を持ちます。
 *
 * @param TYPE スロットが格納する要素の型（[AmountHolder] を継承している必要があります）
 * @param AMOUNT_TYPE 個数を表現する数値の型（[Number] のサブクラス）
 * @property amount 現在の個数
 * @property maxAmount 許容される最大個数
 */
interface MandateSlot<TYPE : AmountHolder<AMOUNT_TYPE>, AMOUNT_TYPE : Number> : Slot<TYPE> {
    var amount: AMOUNT_TYPE
    val maxAmount: AMOUNT_TYPE
}
