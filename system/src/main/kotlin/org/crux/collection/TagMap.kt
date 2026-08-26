package org.crux.collection

import java.util.BitSet
import java.util.PriorityQueue
import javax.swing.text.html.HTML

class TagMap<KEY, VALUE, TAG> {
    private var valueMap = HashMap<KEY, Int>()
    private var valueList = ArrayList<Entry<KEY, VALUE>?>()
    private var tagMap = HashMap<TAG, TagContent>()
    private var blankSlot = PriorityQueue<Int>()

    private var filterFlag = BitSet()

    @Suppress("UNCHECKED_CAST")
    operator fun get(key: KEY): VALUE {
        return valueList[valueMap[key]!!]!!.value
    }

    operator fun set(key: KEY, value: VALUE) {
        if (blankSlot.isEmpty()) {
            valueList.add(Entry(key, value))
            valueMap[key] = valueList.size - 1
        } else {
            val index = blankSlot.poll()
            valueList[index] = Entry(key, value)
            valueMap[key] = index
        }
    }

    fun toList(): ArrayList<VALUE> {
        val result = ArrayList<VALUE>()

        for (value in valueList) {
            if (value?.value != null) result.add(value.value)
        }
        return result
    }

    fun putTag(tag: TAG) {
        tagMap[tag] = TagContent()
    }

    fun setTag(tag: TAG, key: KEY) {
        val content = tagMap[tag]!!

        content.estimateIndex.add(valueMap[key]!!)
        content.referenceIndex.set(valueMap[key]!!)
    }

    fun removeTag(tag: TAG) {
        tagMap.remove(tag)
    }

    fun addFilter(tag: TAG) {
        val content = tagMap[tag]!!

        if (filterFlag.isEmpty) {
            filterFlag = content.referenceIndex.clone() as BitSet
        } else {
            filterFlag.and(content.referenceIndex)
        }
    }

    fun getFilter(): List<VALUE> {
        val result = ArrayList<VALUE>()

        var index = filterFlag.nextSetBit(0)

        while (index >= 0) {
            result.add(valueList[index]!!.value)
            index = filterFlag.nextSetBit(index + 1)
        }

        return result
    }

    fun removeValue(key: KEY) {
        val index = valueMap[key]!!

        valueList[index] = null
        valueMap.remove(key)

        for (tag in tagMap.values) {
            tag.referenceIndex.clear(index)
        }

        blankSlot.add(index)
        filterFlag.clear()
    }

    fun filterClear() {
        filterFlag.clear()
    }

    fun getFilterMapping(): BitSet {
        return filterFlag.clone() as BitSet
    }

    fun setFilterMapping(filter: BitSet) {
        filterFlag = filter
    }

    private class Entry<KEY, VALUE>(val key: KEY, val value: VALUE)
}

class TagContent(
    val estimateIndex: ArrayList<Int> = ArrayList(),
    val referenceIndex: BitSet = BitSet()
)