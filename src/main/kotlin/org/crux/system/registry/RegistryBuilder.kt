package org.crux.system.registry

import kotlin.collections.iterator

class RegistryBuilder {
    private val registryElementMap: MutableMap<RegistryTypeKey<*, *>, MutableList<BuilderElementRegistry<*, *>>> = mutableMapOf()

    @Suppress("UNCHECKED_CAST")
    fun <K, V> build(key: RegistryTypeKey<K, V>): Registry<K, V> {
        val registry: Registry<K, V> = Registry()
        for (builderRegistry in registryElementMap[key] ?: mutableListOf()) {
            for ((k, v) in builderRegistry.registryMap) {
                registry.put(k as K, v as V)
            }
        }
        return registry
    }

    fun <K, V> add(key: RegistryTypeKey<K, V>, buildRegistry: BuilderElementRegistry<K, V>) {
        registryElementMap.getOrPut(key) { mutableListOf() }.add(buildRegistry)
    }
}

data class BuilderElementRegistry<K, V>(
    val registryMap: MutableMap<K, V> = mutableMapOf()
) {
    fun register(key: K, element: V) {
        registryMap[key] = element
    }
}