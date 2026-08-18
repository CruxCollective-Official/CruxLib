package org.crux.item

class MetaData {
    private val metaDataMap = mutableMapOf<MetaDataKey<*>, Any>()

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
}

class MetaDataKey<DATA_TYPE>(
    val name: String
)