package org.crux.item

import org.crux.dummy.item.DummyItem
import org.junit.jupiter.api.Test

class ItemStackTest {
    @Test
    fun `can retrieve the amount and the item`() {
        val item = DummyItem()
        val stack = ItemStack(1, item)

        assert(stack.amount == 1)
        assert(stack.maxAmount == 64)
        assert(stack.item == item)
    }
}