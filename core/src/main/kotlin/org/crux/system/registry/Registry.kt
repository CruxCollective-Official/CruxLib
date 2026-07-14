package org.crux.system.registry

@ConsistentCopyVisibility
data class Registry<K, V> internal constructor(
    private val registryMap: MutableMap<K, V> = mutableMapOf()
) : ImmutableRegistry<K, V> {
    override fun get(key: K): V {
        return registryMap[key]!!
    }

    fun put(key: K, value: V) {
        registryMap[key] = value
    }
}

interface ImmutableRegistry<K, V> {
    fun get(key: K): V
}