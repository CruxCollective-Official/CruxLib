package core

import org.crux.core.Crux
import org.crux.core.CruxRegistryTypeKeys
import org.crux.system.convert.IntegerConvertType
import kotlin.test.Test
import kotlin.test.assertEquals

class CruxTest {
    @Test
    fun `registry returns registered registry`() {
        val registry = Crux.registry(CruxRegistryTypeKeys.CONVERT_TYPE_KEY)

        assertEquals(
            IntegerConvertType().getKeyTag(),
            registry.get("crux:integer").getKeyTag()
        )
    }
}