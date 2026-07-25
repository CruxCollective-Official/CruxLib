package org.crux.system.convert

import org.crux.core.createCruxKey
import org.crux.system.key.Key

/**
 * [Key] 型のデータを扱うための [ConvertType] 実装クラス。
 * 形式: "crux_key>namespace_path" (例: "crux_key>user_profile_id")
 * ※createCruxKey("key") の identifier が "crux_key" になると想定しています。
 */
class KeyConvertType : ConvertType<Key> {
    override fun getKeyTag(): Key {
        return createCruxKey("key")
    }

    override fun stringConvertLogic(source: Key): String {
        return "${getKeyTag().identifier}>${source.identifier}"
    }

    override fun dataTypeConvertLogic(source: String): Key {
        val data = removeTag(getKeyTag().identifier, source)

        val parts = data.split("_", limit = 2)
        require(parts.size == 2) {
            "Invalid Key data format. Expected: <namespace>_<path> but got: $data"
        }

        return Key(namespace = parts[0], path = parts[1])
    }
}