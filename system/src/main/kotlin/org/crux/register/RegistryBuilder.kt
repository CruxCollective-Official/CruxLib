package org.crux.register

import org.crux.holder.IdHolder

class RegistryBuilder internal constructor() {
    private val registryList = mutableListOf<RegistryBranch<*, *>>()

    internal fun build(): RegistryContainer {
        val map = mutableMapOf<RegistryKey<*, *>, Registry<*, *>>()

        for (branch in registryList) {
            branch.addTo(
                map.computeIfAbsent(branch.registryKey) { Registry<Any, Any>() }
            )
        }
        return RegistryContainer(map)
    }

    fun put(branch: RegistryBranch<*, *>) {
        registryList.add(branch)
    }
}

class RegistryContainer(
    private val registryMap: MutableMap<RegistryKey<*, *>, Registry<*, *>>
) {
    @Suppress("UNCHECKED_CAST")
    operator fun <KEY, VALUE : IdHolder<KEY>> get(key: RegistryKey<KEY, VALUE>): ImmutableRegistry<KEY, VALUE> {
        return registryMap[key] as ImmutableRegistry<KEY, VALUE>
    }
}
