package org.crux.register

import org.crux.Crux.CRUX_KEY_MANAGER
import dummy.DummyInstance
import org.crux.annotations.InternalCruxApi
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@InternalCruxApi
class RegistryContainerTest {

    private lateinit var branch: RegistryBranch<Int, DummyInstance>

    private val registryKey = RegistryKey<Int, DummyInstance>(CRUX_KEY_MANAGER.create("test_key"))

    private val dummyInstance = DummyInstance()

    @BeforeTest
    fun setup() {
        branch = RegistryBranch(registryKey)
    }

    @Test
    fun `can be retrieved from the registry object`() {
        val registryObject = branch.create {
            dummyInstance
        }

        val builder = RegistryBuilder()
        builder.put(branch)

        val container = builder.build()

        assertEquals(container[registryKey].get(1), dummyInstance)
    }
}