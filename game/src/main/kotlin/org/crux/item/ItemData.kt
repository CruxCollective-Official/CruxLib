package org.crux.item

class ItemData<AMOUNT_TYPE : Number> (
    val item: Item<AMOUNT_TYPE>,
) {
    private var meta: MetaData? = null

    fun getMeta(): MetaData {
        return meta ?: MetaData()
    }

    fun equalsItemData(other: ItemData<AMOUNT_TYPE>): Boolean {
        return this.item == other.item && this.meta == other.getMeta()
    }
}