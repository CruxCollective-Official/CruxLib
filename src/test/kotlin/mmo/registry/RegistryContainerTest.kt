package mmo.registry

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RegistryContainerTest {
    private val registryTypeKey = RegistryTypeKey<String, Int>()

    @Test
    fun `registry container supports get and set `() {
        val registryContainer = RegistryContainer()

        val registry = Registry<String, Int>()
        registry.register("test", 1)
        registryContainer.set(registryTypeKey, registry)

        assertEquals(1, registryContainer.get(registryTypeKey).get("test"))
    }
}