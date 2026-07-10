package game.item

import system.Key

class MetaData {
    private val map = mutableMapOf<MetaDataKey<*>, Any>()

    operator fun <V> set(key: MetaDataKey<V>, value: V) {
        map[key] = value as Any
    }

    @Suppress("UNCHECKED_CAST")
    operator fun <V> get(key: MetaDataKey<V>): V {
        return map[key] as V
    }
}

data class MetaDataKey<V>(
    val key: Key
)
