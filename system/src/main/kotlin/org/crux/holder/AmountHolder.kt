package org.crux.holder

/**
 * 個数を保有する場合の管理する共通契約です。
 *
 * @param AMOUNT_TYPE 個数の型
 * @property amount 現在の個数
 * @property maxAmount 許容される最大個数
 */
interface AmountHolder<AMOUNT_TYPE> {
    var amount: AMOUNT_TYPE
    val maxAmount: AMOUNT_TYPE
}