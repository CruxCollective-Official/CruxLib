package game.item

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MetaDataTest {
    private var testKey = MetaDataKey<String>()

    @Test
    fun `put and get value`() {
        val meta = MetaData()

        meta[testKey] = "value"

        assertEquals("value", meta[testKey])
    }
}