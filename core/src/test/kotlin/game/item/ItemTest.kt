package game.item

import dummy.DummyItem
import org.crux.game.item.Item
import org.crux.game.item.ItemType
import org.crux.game.item.MetaDataKey
import org.junit.jupiter.api.Test
import org.crux.core.createCruxKey
import kotlin.test.assertEquals

class ItemTest {
    private val itemType: ItemType = DummyItem()

    @Test
    fun `creates item with correct type`() {
        val item = Item(itemType, 64, 1)
        assertEquals(itemType, item.type)
    }

    @Test
    fun `creates item containing metadata`() {
        val testKey = MetaDataKey<String>(createCruxKey("test"))

        val item = Item(itemType, 64, 1)
        val meta = item.metaData

        meta[testKey] = "value"

        assertEquals("value", item.metaData[testKey])
    }
}