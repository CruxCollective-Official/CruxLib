package org.crux.register

import org.crux.holder.IdHolder

class RegistryBranch<KEY, VALUE : IdHolder<KEY>> (
    override val registryKey: RegistryKey<KEY, VALUE>
) : ErasedRegistryBranch {
    private val branchList = ArrayList<RegistryObject<VALUE>>()

    fun create(factory: () -> VALUE): RegistryObject<VALUE> {
        val registryObject = RegistryObject(factory)

        branchList.add(registryObject)

        return registryObject
    }

    override fun addTo(registry: Registry<*, *>) {
        @Suppress("UNCHECKED_CAST")
        addToTyped(registry as Registry<KEY, VALUE>)
    }

    private fun addToTyped(
        registry: Registry<KEY, VALUE>
    ) {
        for (registryObject in branchList) {
            val value = registryObject.get()
            registry.add(value.getID(), value)
        }
    }
}

class RegistryObject<VALUE : Any> (
    val factory: () -> VALUE
) {
    private var instance: VALUE? = null

    fun get(): VALUE {
        if (instance == null) {
            instance = factory()
        }
        return instance!!
    }
}

internal interface ErasedRegistryBranch {
    val registryKey: RegistryKey<*, *>

    fun addTo(registry: Registry<*, *>)
}