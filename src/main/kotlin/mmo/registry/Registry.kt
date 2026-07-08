package mmo.registry

internal class Registry<K, V>(
    private val registryMap: MutableMap<K, V> = mutableMapOf()
) : ImmutableRegistry<K, V> {

    fun register(key: K, element: V) {
        registryMap[key] = element
    }

    override fun get(key: K): V {
        return registryMap[key]!!
    }
}

interface ImmutableRegistry<K, V> {
    fun get(key: K): V
}
