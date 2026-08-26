package org.crux.register

import org.crux.Crux.CRUX_KEY_MANAGER
import dummy.DummyInstance
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.BeforeTest
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertSame

class RegistryBranchTest {

    private lateinit var branch: RegistryBranch<Int, DummyInstance>

    private val registryKey = RegistryKey<Int, DummyInstance>(CRUX_KEY_MANAGER.create("test_key"))

    @BeforeTest
    fun setup() {
        branch = RegistryBranch(registryKey)
    }

    @Test
    fun `can create a registry object`() {
        val registryObject = branch.create {
            DummyInstance()
        }

        assertNotNull(registryObject)
    }

    @Test
    fun `create does not instantiate the value`() {
        var initialized = false

        val registryObject = branch.create {
            initialized = true
            DummyInstance()
        }

        assertFalse(initialized)

        registryObject.get()

        assertTrue(initialized)
    }

    @Test
    fun `created registry object can retrieve its value`() {
        val dummyInstance = DummyInstance()

        val registryObject = branch.create {
            dummyInstance
        }

        assertSame(dummyInstance, registryObject.get())
    }

    @Test
    fun `can create multiple registry objects`() {
        val first = DummyInstance()
        val second = DummyInstance()

        val firstObject = branch.create {
            first
        }

        val secondObject = branch.create {
            second
        }

        assertSame(first, firstObject.get())
        assertSame(second, secondObject.get())
    }

    @Test
    fun `each registry object keeps its own instance`() {
        var firstCount = 0
        var secondCount = 0

        val first = branch.create {
            firstCount++
            DummyInstance()
        }

        val second = branch.create {
            secondCount++
            DummyInstance()
        }

        first.get()
        first.get()

        second.get()
        second.get()

        assertEquals(1, firstCount)
        assertEquals(1, secondCount)
    }
}