package game.item

import dummy.DummyItem
import org.junit.jupiter.api.Test
import system.Key
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
        val testKey = MetaDataKey<String>(Key("curx", "test"))

        val item = Item(itemType)
        val meta = item.metaData

        meta[testKey] = "value"

        assertEquals("value", item.metaData[testKey])
    }
}