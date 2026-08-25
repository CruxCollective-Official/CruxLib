package org.crux.collection

class AbsoluteTable<KEY, VALUE> {
    private val mappingMap: MutableMap<KEY, AbsoluteMappingObject> = HashMap()
    private val mappingList = ArrayList<AbsoluteMappingObject>()

    private val dataMap: MutableMap<AbsoluteMappingObject, VALUE?> = HashMap()

    fun add(key: KEY, value: VALUE?) {
        if (!mappingMap.containsKey(key)) {
            val mappingObj = AbsoluteMappingObject()
            mappingList.add(mappingObj)
            mappingMap[key] = mappingObj
            dataMap[mappingObj] = value
        }
    }

    fun set(index: Int, value: VALUE?) {
        if (mappingList.size > index) {
            val mappingObj = mappingList[index]
            dataMap[mappingObj] = value
        }
    }

    fun set(key: KEY, value: VALUE?) {
        if (mappingMap.containsKey(key)) {
            val mappingObj = mappingMap[key]
            if (mappingObj != null) dataMap[mappingObj] = value
        }
    }

    fun get(index: Int): VALUE? {
        return dataMap[mappingList[index]]
    }

    fun get(key: KEY): VALUE? {
        return dataMap[mappingMap[key]]
    }

    fun remove(index: Int) {

    }

    fun remove(key: KEY) {

    }
}

internal class AbsoluteMappingObject