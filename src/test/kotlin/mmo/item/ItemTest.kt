package mmo.item

import dummy.DummyItem
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ItemTest {
    private val itemType: ItemType = DummyItem()

    @Test
    fun `creates item with correct type`() {
        val item = Item(itemType)
        assertEquals(itemType, item.type)
    }

    @Test
    fun `creates item containing metadata`() {
        val testKey = MetaDataKey<String>()

        val item = Item(itemType)
        val meta = MetaData()

        meta[testKey] = "value"
        item.metaData = meta

        assertEquals("value", item.metaData[testKey])
    }
}