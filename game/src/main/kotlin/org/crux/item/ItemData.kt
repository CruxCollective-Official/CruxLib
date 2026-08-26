package org.crux.item

data class ItemData<TYPE : Item> (
    val item: TYPE,
    private var meta: MetaData? = null
) {

    fun getMeta(): MetaData {
        return meta ?: MetaData()
    }

    fun setMeta(meta: MetaData) {
        this.meta = meta
    }

    fun equalsItemData(other: ItemData<TYPE>): Boolean {
        return this.item == other.item && this.meta == other.getMeta()
    }

    fun copy(): ItemData<TYPE> {
        return ItemData(item, meta?.copy() ?: MetaData())
    }
}