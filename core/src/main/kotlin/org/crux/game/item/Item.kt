package org.crux.game.item

/**
 * ゲーム内に存在する個々のアイテムを表すデータクラス。
 *
 * アイテムの根本的な種類を定義する [ItemType] と、
 * アイテムの最大スタック数 [maxAmount] と現状スタック数 [amount] と、
 * 個体ごとに異なる固有情報（耐久度、強化値、カスタム名など）を管理する [MetaData] を保持します。
 *
 * @property type アイテムの定義クラス
 * @property metaData アイテム個別の追加情報・メタデータ。デフォルトは空（初期状態）の [MetaData] インスタンス
 * @property maxAmount アイテムの最大スタック数で1以上しか許容されない
 * @property amount アイテムのスタック数で1以上 [maxAmount] 以下しか許容されない
 */
data class Item(
    val type: ItemType,
    val maxAmount: Long,
    val amount: Long,
    val metaData: MetaData = MetaData()
) {
    init {
        require(amount >= 1) { "amountは1以上である必要があります: $amount" }
        require(maxAmount >= 1) { "maxAmountは1以上である必要があります: $maxAmount" }
        require(amount <= maxAmount) { "amount($amount)はmaxAmount($maxAmount)以下である必要があります" }
    }
}
