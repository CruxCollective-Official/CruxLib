package mmo.item

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MetaDataTest {
    private var testKey = MetaDataKey<String>("test")

    @Test
    fun `put and get value`() {
        val meta = MetaData()

        meta.put(testKey, "value")

        assertEquals("value", meta.get(testKey))
    }
}