package game.item

/**
 * ゲーム内に存在する個々のアイテムを表すデータクラス。
 *
 * アイテムの根本的な種類を定義する [ItemType] と、
 * 個体ごとに異なる固有情報（耐久度、強化値、カスタム名など）を管理する [MetaData] を保持します。
 *
 * @property type アイテムの定義クラス
 * @property metaData アイテム個別の追加情報・メタデータ。デフォルトは空（初期状態）の [MetaData] インスタンス
 */
data class Item(
    val type: ItemType,
    val metaData: MetaData = MetaData()
)
