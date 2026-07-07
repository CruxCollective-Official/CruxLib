package mmo.registry

import kotlin.test.Test
import kotlin.test.assertEquals

class RegistryTest {
    @Test
    fun `test registry register and get`() {
        val registry: Registry<Int, String> = Registry()
        val element = "test"

        registry.register(1, element)

        assertEquals(element, registry.get(1))
    }
}