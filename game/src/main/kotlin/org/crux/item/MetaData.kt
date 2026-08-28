package org.crux.item

import kotlin.collections.mutableMapOf

/**
 * メタデータの識別キー（[MetaDataKey]）で管理されたマップをラップしたデータクラスです。
 *
 * 同じ対象に違うデータ（耐久残存値やsuffix）を持たせたい場合に使用します。
 *
 * @property metaDataMap MetaDataが保有するデータ。 [MetaDataKey]をキーにして
 * データをジェネリクスで固定・復元します。
 */
data class MetaData (
    private val metaDataMap: MutableMap<MetaDataKey<*>, Any> = mutableMapOf()
) {
    /**
     * [MetaDataKey]に応じたデータを[metaDataMap]から取得できます。
     * 返される値は[MetaDataKey]が持つジェネリクスによって内部データの値は復元されますが
     * 多層ジェネリクスは消失するため注意が必要です。
     *
     * @param DATA_TYPE 戻り値の型保障
     * @param key [metaDataMap]を参照する際のキー
     * @return MetaDataに保存された[MetaDataKey]と紐づくデータ
     */
    @Suppress("UNCHECKED_CAST")
    operator fun <DATA_TYPE> get(key: MetaDataKey<DATA_TYPE>): DATA_TYPE {
        return metaDataMap[key] as DATA_TYPE
    }

    /**
     * [MetaDataKey]を[key]として、[DATA_TYPE]型の[data]を[metaDataMap]に保存します。
     *
     * @param DATA_TYPE 保存時に[MetaDataKey]が期待する型と[data]の型を一致させる
     * @param key [data]のキーとなり取得時の型保障情報
     * @param data 保存する内部データの一つ
     */
    operator fun <DATA_TYPE> set(key: MetaDataKey<DATA_TYPE>, data: DATA_TYPE) {
        metaDataMap[key] = data as Any
    }

    /**
     * [MetaData]の中身をコピーした読み取り専用の[ValueMetaData]を作成して返します。
     *
     * @return 自身の中身をコピーした新規[ValueMetaData]インスタンス
     */
    fun copy(): ValueMetaData {
        // toMutableMap() または toMap() を使うことで、元のマップの参照を切った独立したコピーを作れます
        return ValueMetaData(metaDataMap.toMap())
    }
}

/**
 * [MetaData]から複製された、値の書き換えができない読み取り専用のメタデータクラスです。
 *
 * @property metaDataMap 読み取り専用として保持する内部データマップ
 */
data class ValueMetaData (
    private val metaDataMap: Map<MetaDataKey<*>, Any>
) {
    /**
     * [MetaDataKey]に応じたデータを取得します。
     *
     * @param DATA_TYPE 戻り値の型保障
     * @param key 参照する際のキー
     * @return 保存されている[MetaDataKey]と紐づくデータ
     */
    @Suppress("UNCHECKED_CAST")
    operator fun <DATA_TYPE> get(key: MetaDataKey<DATA_TYPE>): DATA_TYPE {
        return metaDataMap[key] as DATA_TYPE
    }
}

/**
 * メタデータ専用の管理キークラスです。
 *
 * @param DATA_TYPE 紐づくデータの型を保障
 * @property name デバッグ用や名前管理等に使用可能なデータ
 */
class MetaDataKey<DATA_TYPE>(
    val name: String
)