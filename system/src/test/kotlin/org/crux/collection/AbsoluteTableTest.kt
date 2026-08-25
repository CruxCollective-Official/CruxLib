package org.crux.collection

import org.crux.dummy.DummyInstance
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class AbsoluteTableTest {
    private val instance1 = DummyInstance()
    private val instance2 = DummyInstance()
    private val instance3 = DummyInstance()

    @Test
    fun `supports a set and add operation and two types of special get operations`() {
        val table: AbsoluteTable<String, DummyInstance> = AbsoluteTable()

        table.add("test1", instance1)
        table.add("test2", null)

        assertEquals(instance1, table.get(0))
        assertEquals(instance1, table.get("test1"))
        assertNull(table.get(1))

        table.set(1, instance2)
        assertEquals(instance2, table.get(1))

        table.set("test2", instance3)
        assertEquals(instance3, table.get(1))
    }

    @Test
    fun `can remove elements using remove`() {
        val table: AbsoluteTable<String, DummyInstance> = AbsoluteTable()

        table.add("test1", instance1)
        table.add("test2", instance2)
        table.add("test3", instance3)

        table.remove(0)
        assertEquals(instance2, table.get(0))

        table.remove("test2")
        assertEquals(instance3, table.get(0))
    }
}