package system

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class KeyTest {
    @Test
    fun `creates key with namespace and path`() {
        val key = Key("test", "path")
        assertEquals("test", key.namespace)
        assertEquals("path", key.path)
        assertEquals("test:path", key.identifier)
    }
}