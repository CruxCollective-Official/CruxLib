package game.item

import org.junit.jupiter.api.Test
import system.key.createCruxKey
import kotlin.test.assertEquals

class MetaDataTest {
    private var testKey = MetaDataKey<String>(createCruxKey("test"))

    @Test
    fun `put and get value`() {
        val meta = MetaData()

        meta[testKey] = "value"

        assertEquals("value", meta[testKey])
    }

    @Test
    fun `can get the path of the item`() {
        val meta = MetaData()
    }
}