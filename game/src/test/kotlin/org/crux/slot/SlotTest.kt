package org.crux.slot

import dummy.slot.DummySlot
import dummy.slot.DummyTank
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SlotTest {
    @Test
    fun `supports get and put operations`() {
        val slot = DummySlot(DummyTank(1))
        slot.content = DummyTank(0)

        assertEquals(0, slot.content.amount)
    }

    @Test
    fun `can be made mutable mandate`() {
        val slot = DummySlot(DummyTank(1))
        slot.content = DummyTank(0)

        slot.amount = 10

        assertEquals(10, slot.amount)
    }
}