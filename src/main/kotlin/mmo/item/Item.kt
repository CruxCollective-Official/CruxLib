package mmo.item

data class Item(
    val type: ItemType
) {
    var metaData: MetaData = MetaData()
}
