package mmo.item

class MetaData {
    private val map = mutableMapOf<MetaDataKey<*>, Any>()

    fun <V> put(key: MetaDataKey<V>, value: V) {
        map[key] = value as Any
    }

    @Suppress("UNCHECKED_CAST")
    fun <V> get(key: MetaDataKey<V>): V {
        return map[key] as V
    }
}
