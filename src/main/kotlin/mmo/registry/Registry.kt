package mmo.registry

class Registry<K, V>(
    private val registryMap: MutableMap<K, V> = mutableMapOf()
) {
    fun register(key: K, element: V) {
        registryMap[key] = element
    }

    fun get(key: K): V {
        return registryMap[key]!!
    }
}
