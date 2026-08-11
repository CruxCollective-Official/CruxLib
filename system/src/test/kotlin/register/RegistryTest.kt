package register

import org.crux.register.Registry
import kotlin.test.Test
import kotlin.test.assertEquals

class RegistryTest {
    @Test
    fun `registry supports add and get operations`() {
        val registry = Registry<Int, String>()
        registry.add(1, "one")

        assertEquals("one" ,registry.get(1))
    }
}