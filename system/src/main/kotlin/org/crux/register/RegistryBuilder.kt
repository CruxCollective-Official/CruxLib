package org.crux.register

import org.crux.holder.IdHolder

class RegistryBuilder internal constructor() {
    private val registryList = ArrayList<RegistryBranch<*, *>>()

    internal fun build(): RegistryContainer {
        val map = mutableMapOf<RegistryKey<*, *>, Registry<*, *>>()

        for (branch in registryList) {
            if (branch.registryKey !in map) {
                map[branch.registryKey] = Registry<Any, Any>()
            }

            branch.addTo(map[branch.registryKey] as Registry<*, *>)
        }
        return RegistryContainer(map)
    }

    fun put(branch: RegistryBranch<*, *>) {
        registryList.add(branch)
    }
}

@Suppress("UNCHECKED_CAST")
class RegistryContainer(
    private val registryMap: MutableMap<RegistryKey<*, *>, Registry<*, *>>
) {
    operator fun <KEY, VALUE : IdHolder<KEY>> get(key: RegistryKey<KEY, VALUE>): ImmutableRegistry<KEY, VALUE> {
        return registryMap[key] as Registry<KEY, VALUE>
    }
}
