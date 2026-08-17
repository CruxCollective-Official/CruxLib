package org.crux.register

import org.crux.register.RegistryObject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertSame

class RegistryObjectTest {

    @Test
    fun `do not execute the factory during generation`() {
        var count = 0

        RegistryObject {
            count++
            "test"
        }

        assertEquals(0, count)
    }

    @Test
    fun `calling get executes the factory`() {
        var count = 0

        val obj = RegistryObject {
            count++
            "test"
        }

        obj.get()

        assertEquals(1, count)
    }

    @Test
    fun `the factory is executed only once, even if get is called multiple times`() {
        var count = 0

        val obj = RegistryObject {
            count++
            "test"
        }

        val first = obj.get()
        val second = obj.get()

        assertEquals(1, count)
        assertSame(first, second)
    }
}