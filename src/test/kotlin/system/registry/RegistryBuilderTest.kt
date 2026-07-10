package system.registry

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RegistryBuilderTest {
    private val key: RegistryTypeKey<String, Int> = RegistryTypeKey()

    @Test
    fun `registry builder supports build and add`() {
        val builder = RegistryBuilder()

        val regi = BuilderElementRegistry<String, Int>()
        regi.register("one", 1)
        regi.register("two", 2)
        builder.add(key, regi)

        val registry = builder.build(key)
        assertEquals(1, registry.get("one"))
        assertEquals(2, registry.get("two"))
    }
}