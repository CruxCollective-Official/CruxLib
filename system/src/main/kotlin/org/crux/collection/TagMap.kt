package org.crux.collection

import java.util.BitSet
import java.util.PriorityQueue

/**
 *
 */
class TagMap<KEY, VALUE, TAG> {
    private var valueMap = HashMap<KEY, Int>()
    private var valueList = ArrayList<Entry<KEY, VALUE>?>()
    private var tagMap = HashMap<TAG, TagContent>()
    private var blankSlot = PriorityQueue<Int>()

    private var filterFlag = BitSet()

    /**
     * 指定されたキーの存在有無を判定します。要素操作前の安全確認に使用します。
     */
    fun containsKey(key: KEY): Boolean = valueMap.containsKey(key)

    /**
     * 指定されたタグの存在有無を判定します。タグ操作前の安全確認に使用します。
     */
    fun containsTag(tag: TAG): Boolean = tagMap.containsKey(tag)

    @Suppress("UNCHECKED_CAST")
    operator fun get(key: KEY): VALUE {
        val index = valueMap[key] ?: throw NoSuchElementException("Key '$key' is not registered in this TagMap.")
        return valueList[index]!!.value
    }

    /**
     * 指定された既存のキーに対応する要素を、新しい値で上書き（置換）します。
     *
     * ※このメソッドを呼び出す前に、対象のキーがすでに登録されている必要があります。
     *
     * @param key 上書き対象の登録済みキー
     * @param value 新しく設定する要素データ
     * @throws NoSuchElementException 指定されたキーが登録されていない場合
     */
    operator fun set(key: KEY, value: VALUE) {
        val index = valueMap[key] ?: throw NoSuchElementException("Cannot set value: Key '$key' is not registered in this TagMap. Use add() to insert a new element.")
        valueList[index] = Entry(key, value)
    }

    /**
     * 新しい要素をコンテナに登録します。
     *
     * 内部で過去に削除された空きスロット（インデックス）がある場合は、
     * メモリ効率とデータ走査速度を維持するために優先的に再利用されます。
     *
     * @param key 新規登録する要素のキー
     * @param value 登録する要素データ
     */
    fun add(key: KEY, value: VALUE) {
        if (valueMap.containsKey(key)) {
            error("Cannot add value: Key '$key' is already registered. Use set() if you want to overwrite the existing value.")
        }

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