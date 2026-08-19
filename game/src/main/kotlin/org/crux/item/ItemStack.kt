package org.crux.item

class ItemStack<AMOUNT_TYPE : Number> (
    var amount: AMOUNT_TYPE,
    val item: Item<AMOUNT_TYPE>,
    val maxAmount: AMOUNT_TYPE = item.maxAmount()
) {
    private var meta: MetaData? = null

    fun getMeta(): MetaData {
        return meta ?: MetaData()
    }

    fun equalsItemStack(other: ItemStack<AMOUNT_TYPE>): Boolean {
        return this.item == other.item && this.amount == other.amount && this.meta == other.getMeta()
    }
}