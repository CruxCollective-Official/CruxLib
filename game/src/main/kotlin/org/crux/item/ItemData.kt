package org.crux.item

/**
 * アイテム（[Item]）とそれが持つ内部データ（[MetaData]）を保持するデータクラスです。
 *
 * どのアイテムでどんな内部データを持つのかを、スタック数などの概念と切り分けて管理するときに使用します。
 *
 * @param TYPE 管理するアイテムの型
 * @property item アイテムのインスタンス
 * @property meta アイテムに紐づく内部データ。外部からは直接変更できません。
 */
data class ItemData<TYPE : Item> (
    val item: TYPE,
    private var meta: MetaData? = null
) {

    /**
     * 内部データ（`meta`）の読み取り専用コピーを取得します。
     *
     * カプセル化の安全性を保つため、内部のマップ構造が複製された [ValueMetaData] のインスタンスを返します。
     * 内部データ（`meta`）が `null` の場合は、新規に生成された空の [ValueMetaData] インスタンスを返します。
     *
     * @return 読み取り専用に複製された [ValueMetaData] インスタンス
     */
    fun getMeta(): ValueMetaData {
        return meta?.copy() ?: ValueMetaData(mapOf())
    }

    /**
     * メタデータを新しいインスタンスで上書きします。
     *
     * @param meta 上書きするメタデータのインスタンス
     */
    fun setMeta(meta: MetaData) {
        this.meta = meta
    }
}
