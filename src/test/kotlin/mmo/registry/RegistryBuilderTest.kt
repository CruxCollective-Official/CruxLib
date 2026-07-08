package mmo.registry

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RegistryBuilderTest {
    private val key: RegistryTypeKey<String, Int> = RegistryTypeKey()

    @Test
    fun `registry builder supports build and add`() {
        val builder = RegistryBuilder()

        val registry1 = Registry<String, Int>()
        val registry2 = Registry<String, Int>()

        registry1.register("one", 1)
        registry1.register("two", 2)

        builder.add(key, registry1)
        builder.add(key, registry2)

        val registry = builder.build(key)
        assertEquals(1, registry["one"])
        assertEquals(2, registry["two"])
    }
}