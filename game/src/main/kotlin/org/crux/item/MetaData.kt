package org.crux.item

import kotlin.collections.mutableMapOf

data class MetaData (
    private val metaDataMap: MutableMap<MetaDataKey<*>, Any> = mutableMapOf()
) {
    @Suppress("UNCHECKED_CAST")
    operator fun <DATA_TYPE> get(key: MetaDataKey<DATA_TYPE>): DATA_TYPE {
        return metaDataMap[key] as DATA_TYPE
    }

    operator fun <DATA_TYPE> set(key: MetaDataKey<DATA_TYPE>, data: Any) {
        metaDataMap[key] = data
    }

    fun equalsMetaData(other: MetaData): Boolean {
        return metaDataMap == other.metaDataMap
    }

    fun copy(): MetaData {
        val copyMap: MutableMap<MetaDataKey<*>, Any> = mutableMapOf()
        copyMap.putAll(metaDataMap)
        return MetaData(copyMap)
    }
}

class MetaDataKey<DATA_TYPE>(
    val name: String
)