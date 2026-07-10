package system.registry

import kotlin.test.Test
import kotlin.test.assertEquals

class RegistryTest {
    @Test
    fun `test registry register and get`() {
        val element = "test"

        val map: MutableMap<Int, String> = mutableMapOf(1 to element)
        val registry: Registry<Int, String> = Registry(map)

        assertEquals(element, registry.get(1))
    }
}