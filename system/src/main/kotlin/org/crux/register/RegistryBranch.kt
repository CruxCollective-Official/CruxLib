package org.crux.register

import org.crux.holder.IdHolder

class RegistryBranch<KEY, VALUE : IdHolder<KEY>>(
    val registryKey: RegistryKey<KEY, VALUE>
) {
    private val branchList = mutableListOf<RegistryObject<VALUE>>()

    fun create(factory: () -> VALUE): RegistryObject<VALUE> {
        val registryObject = RegistryObject(factory)

        branchList.add(registryObject)

        return registryObject
    }

    internal fun addTo(registry: Registry<*, *>) {
        @Suppress("UNCHECKED_CAST")
        addToTyped(registry as Registry<KEY, VALUE>)
    }

    private fun addToTyped(
        registry: Registry<KEY, VALUE>
    ) {
        for (registryObject in branchList) {
            val value = registryObject.get()
            registry.add(value.id, value)
        }
    }
}

class RegistryObject<VALUE : Any> internal constructor(factory: () -> VALUE) {
    private val instance by lazy(factory)

    fun get(): VALUE = instance
}
