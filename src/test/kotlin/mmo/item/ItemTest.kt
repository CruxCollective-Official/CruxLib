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
}