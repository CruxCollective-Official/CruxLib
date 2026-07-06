package mmo.item

data class Item(
    val type: ItemType,
    val metaData: MetaData = MetaData()
)
